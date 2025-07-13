package com.codtech;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * RecommenderApp - A simple Java-based recommendation system using Apache Mahout.
 *
 * This application reads a dataset from a CSV file located in the resources folder,
 * creates a user-based collaborative filtering recommender system, and
 * prints out recommendations for a given user.
 *
 * Author: Yabez Yalsatty
 * Organization: CodTech
 * Date: 13 July 2025
 */
public class RecommenderApp {
    public static void main(String[] args) {
        try {
            /**
             * Step 1: Load the CSV dataset file from resources.
             * The file should be located at: src/main/resources/data/dataset.csv
             * ClassLoader loads it as an InputStream.
             */
            InputStream inputStream = RecommenderApp.class.getClassLoader()
                    .getResourceAsStream("data/dataset.csv");

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found in resources: data/dataset.csv");
            }

            /**
             * Step 2: Since FileDataModel requires a physical file,
             * copy the InputStream to a temporary file.
             */
            File tempFile = File.createTempFile("dataset", ".csv");
            Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            /**
             * Step 3: Create a DataModel from the CSV file.
             * Format: userID,itemID,preference (e.g., 1,101,4.0)
             */
            DataModel model = new FileDataModel(tempFile);

            /**
             * Step 4: Define the similarity metric to compare users.
             * Pearson Correlation is used here.
             */
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            /**
             * Step 5: Find the N (e.g., 2) most similar users (neighbors).
             */
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

            /**
             * Step 6: Build the user-based recommender.
             */
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            /**
             * Step 7: Generate and display top N (e.g., 3) recommendations for user ID = 1.
             */
            List<RecommendedItem> recommendations = recommender.recommend(1, 3);

            System.out.println("Recommendations for user 1:");
            for (RecommendedItem recommendation : recommendations) {
                System.out.printf("Item: %d, Value: %.2f\n", recommendation.getItemID(), recommendation.getValue());
            }

        } catch (Exception e) {
            // Handle and print any exception that occurs during recommendation
            e.printStackTrace();
        }
    }
}

