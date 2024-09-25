# CRUD Operation using Java, JDBC, and Oracle

A Java project demonstrating basic CRUD (Create, Read, Update, Delete) operations using JDBC with an Oracle database.

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java JDK 8 or later**
- **Oracle Database** (either local or a cloud-hosted instance)
- **Oracle JDBC Driver** (ojdbc8.jar)
- **IDE** (Eclipse, IntelliJ IDEA, etc.)
- **SQL Developer** (Optional, for managing Oracle database)

## Setup Instructions

### Step 1: Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/srsajal/curd_operation_using_Java_JDBC_Oracle.git
cd curd_operation_using_Java_JDBC_Oracle
```
## Step 2: Create a New Schema

Log in to Oracle as an admin user and create a new schema (user) for the project by running the following SQL commands:

```sql
CREATE USER studentdb IDENTIFIED BY your_password;
GRANT CONNECT, RESOURCE TO studentdb;
```
## Step 3: Configure JDBC Connection

To configure the JDBC connection, follow these steps:

1. Open the project in your IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans).

2. Locate the section in the code where the connection to the database is established (usually found in a configuration file or inside the DAO classes).

3. Modify the connection settings to match your Oracle database credentials:

```java
// Example of JDBC connection configuration
String url = "jdbc:oracle:thin:@localhost:1521:xe";  // Replace with your Oracle connection string
String username = "studentdb";  // Replace with your Oracle database username
String password = "your_password";  // Replace with your Oracle database password

Connection connection = DriverManager.getConnection(url, username, password);
```
## Step 4: Add Oracle JDBC Driver

### 1. Download the Oracle JDBC Driver
Download the `ojdbc8.jar` from [Oracle's official website]([https://www.oracle.com/database/technologies/appdev/jdbc-ucp-191-downloads.html](https://www.oracle.com/in/database/technologies/appdev/jdbc-downloads.html)).

### 2. Add the .jar file to your project's classpath

#### For Maven Projects
Add the Oracle JDBC dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>19.8.0.0</version>
</dependency>
```
# Project Setup and Operations

## Step 5: Compile and Run the Project

Follow these instructions to compile and run the project using your preferred IDE. Once the project is up and running, you will be able to perform the following operations:

### 1. Insert Student Records
To insert student records into the database, you can use the provided interface or API endpoint to add new student information. Ensure you provide all required details, such as name, roll number, and other relevant fields.

### 2. Retrieve All Students
To retrieve a list of all student records, use the designated method or endpoint. This will return a collection of all students currently stored in the database.

### 3. Retrieve a Student by Roll Number
You can retrieve details of a specific student using their roll number. Provide the roll number to the search function or endpoint to get the student's information.

### 4. Update Student Details
To update the details of an existing student, use the update functionality provided. Input the roll number of the student you want to update and modify the necessary fields.

### 5. Delete Student Records
To delete a student record, use the delete functionality by specifying the roll number of the student you wish to remove from the database.

### 6. Search for Students by Name
To search for students by name, use the search feature provided. Enter the student's name (or a part of it) to find matching records.

## Running the Project

1. **Compile the Project:**
   - Open your IDE.
   - Load the project.
   - Compile the project using the build option or command.

2. **Run the Project:**
   - After successful compilation, run the project using the run option or command in your IDE.

3. **Perform Operations:**
   - Use the provided user interface or API endpoints to perform the operations described above.

Ensure that you have all necessary configurations and dependencies set up before running the project.

---
# CRUD Operations with Oracle Database

## Steps

### Step 6: Test CRUD Operations
1. Use SQL Developer or another Oracle database client to verify that records are being created, updated, and deleted in the `students` table.
2. Check the output from the application to ensure it matches the database state.

### Step 7: Close Database Connection
1. Ensure that the database connection is closed properly by calling the `close()` method in the code or using Java’s try-with-resources statement.

## Troubleshooting

### Connection Issues
- Ensure the database URL, username, and password are correct.
- Verify that your Oracle database is running.

### Missing JDBC Driver
- Ensure that the `ojdbc8.jar` file is properly added to the classpath.

### Database Permissions
- Verify that the `studentdb` user has sufficient permissions to create, read, update, and delete records.

## Contributing
Feel free to post issues, fork the repository and submit pull requests with improvements.
# <p align="center">HAPPY LEARNING</p>
