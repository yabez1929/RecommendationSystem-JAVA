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

RecommendationSystem/
├── pom.xml
├── README.md
├── .gitignore
└── src/
├── main/
│ ├── java/
│ │ └── com/
│ │ └── codtech/
│ │ └── RecommenderApp.java
│ └── resources/
│ └── data/
│ └── dataset.csv

yaml
----
## 📦 How to Run the Project

### 1️⃣ Clone the repository:
git clone https://github.com/YOUR-USERNAME/RecommendationSystem-JAVA.git

2️⃣ Navigate into the folder:
cd RecommendationSystem-JAVA

3️⃣ Run using Maven:
mvn clean compile exec:java -DexecmainClass="com.codtech.RecommenderApp"

🧪 Sample Output:
Recommendations for user 1:
RecommendedItem[item:105, value:4.8]
RecommendedItem[item:107, value:4.6]
You can change the user ID in RecommenderApp.java to test for other users.

📊 Dataset Format
Your dataset.csv file should follow this structure:

csv:
userID,itemID,preferenceValue
1,101,4.5
1,102,3.0
2,101,2.5
2,103,5.0

🧑‍💻 Author
Yabez Yalsatty
CodTech Internship | B.Sc. Computer Science Student, B.K. Birla College

📃 License
This project is licensed under the MIT License.


