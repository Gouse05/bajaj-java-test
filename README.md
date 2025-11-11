\# Bajaj Finserv Health – JAVA Hiring Challenge  

Automated Spring Boot project to generate webhook, receive access token, solve the assigned SQL question, and submit the solution programmatically.



---



\## ✅ Project Overview

This project was built as part of the \*\*Bajaj Finserv Health – PES University JAVA Hiring Assessment\*\*.

It performs the full workflow automatically when the Spring Boot application starts:



1\. Sends POST request to \*\*generateWebhook\*\*

2\. Receives `webhook` URL and `accessToken`

3\. Determines SQL Question based on Registration Number

4\. Submits the final SQL answer to the webhook

5\. Prints the server response



All logic is implemented inside `CommandLineRunner`.  

✅ No controllers  

✅ Fully automated workflow



---



\## ✅ Tech Stack

\- Java 17  

\- Spring Boot 3.2.2  

\- Spring WebClient  

\- Maven  



---



\## ✅ How to Run

\### 1️⃣ Clone the repository

git clone https://github.com/Gouse05/bajaj-java-test.git  

cd bajaj-java-test



\### 2️⃣ Build the JAR

mvn clean package



\### 3️⃣ Run the application

java -jar target/bajaj-java-test-1.0.0.jar



You will see:  

✅ Webhook response  

✅ Access token  

✅ Final SQL submission result  



---



\## ✅ SQL Query Submitted (Question 2)

SELECT 

&nbsp;   e1.emp\_id,

&nbsp;   e1.first\_name,

&nbsp;   e1.last\_name,

&nbsp;   d.department\_name,

&nbsp;   COUNT(e2.emp\_id) AS younger\_employees\_count

FROM employee e1

JOIN department d 

&nbsp;       ON e1.department = d.department\_id

LEFT JOIN employee e2

&nbsp;       ON e2.department = e1.department

&nbsp;      AND e2.dob > e1.dob

GROUP BY 

&nbsp;   e1.emp\_id, e1.first\_name, e1.last\_name, d.department\_name

ORDER BY 

&nbsp;   e1.emp\_id DESC;



---



\## ✅ Folder Structure

bajaj-java-test  

&nbsp;├── pom.xml  

&nbsp;├── README.md  

&nbsp;├── src  

&nbsp;│   └── main  

&nbsp;│        ├── java  

&nbsp;│        │    └── com  

&nbsp;│        │         └── bajaj  

&nbsp;│        │              └── test  

&nbsp;│        │                   └── Application.java  

&nbsp;│        └── resources  

&nbsp;└── target  

&nbsp;     └── bajaj-java-test-1.0.0.jar



---



\## ✅ Author

\*\*Sheik Gouse Pasha\*\*  

Reg No: \*\*PES1UG22CS556\*\*  

Email: \*\*gouse05.x@gmail.com\*\*



---



\## ✅ Purpose

This project is part of the Bajaj Finserv Health hiring test.

It automatically:



✅ Generates webhook  

✅ Receives JWT access token  

✅ Submits SQL query  

✅ Prints final server confirmation  



---



\## ✅ License

This project is created solely for the hiring assessment and is not intended for production use.



