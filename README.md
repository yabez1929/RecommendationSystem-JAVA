# RecommendationSystem-JAVA

A Java-based AI Recommendation System that uses **Apache Mahout** to suggest products or content based on user preferences. This project is designed as part of a learning internship at **CodTech**, and demonstrates how collaborative filtering can be implemented using the Mahout framework.

---

## 🚀 Features

- 📊 Reads user-item preference data from a CSV file
- 🤖 Builds a recommender engine using Apache Mahout
- 📈 Outputs personalized recommendations for a given user
- 📦 Maven-based Java project structure

---

## 🛠 Technologies Used

- Java 8+
- Apache Maven
- Apache Mahout (Recommender library)
- SLF4J (for logging)

---

## 📁 Project Structure

---

## 📦 How to Run the Project

### 1️⃣ Clone the repository
git clone https://github.com/YOUR-USERNAME/RecommendationSystem-JAVA.git

Run using Maven:
mvn clean compile exec:java -Dexec.mainClass="com.codtech.RecommenderApp"

Sample Output:
Recommendations for user 1:
RecommendedItem[item:105, value:4.8]
RecommendedItem[item:107, value:4.6]
