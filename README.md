# Student Management System – Spring Boot CRUD

A simple **Student Management REST API** built using **Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project demonstrates the implementation of basic **CRUD operations** using a layered architecture with Controller, Service, Repository, and Entity layers.

## 🚀 Features

* Create Student
* Get Student by ID
* Get All Students
* Update Student
* Delete Student
* MySQL database integration
* RESTful APIs
* Spring Data JPA
* Hibernate ORM
* Layered architecture
* HTTP status handling using `ResponseEntity`

## 🛠️ Technologies Used

| Technology      | Version / Usage     |
| --------------- | ------------------- |
| Java            | 21                  |
| Spring Boot     | 4.1.0               |
| Spring Web MVC  | REST APIs           |
| Spring Data JPA | Database operations |
| Hibernate       | ORM                 |
| MySQL           | Database            |
| Maven           | Build Tool          |
| JUnit           | Testing             |

## 📁 Project Structure

```text
crudSpringBoot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── in/avinash/crudSpringBoot/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       │
│   │   │       ├── entity/
│   │   │       │   └── Student.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── StudentService.java
│   │   │       │
│   │   │       └── CrudSpringBootApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── CrudSpringBootApplicationTests.java
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🏗️ Architecture

The project follows a simple layered architecture:

```text
Client / Postman
       │
       ▼
 Controller
       │
       ▼
  Service Layer
       │
       ▼
 Repository Layer
       │
       ▼
 MySQL Database
```

### Controller Layer

Handles HTTP requests and exposes REST API endpoints.

Main annotations used:

* `@RestController`
* `@RequestMapping`
* `@PostMapping`
* `@GetMapping`
* `@PutMapping`
* `@DeleteMapping`
* `@RequestBody`
* `@PathVariable`

### Service Layer

Contains the business logic and communicates with the repository.

### Repository Layer

Uses `JpaRepository` to perform database operations without writing SQL queries manually.

### Entity Layer

The `Student` class is mapped to a database table using JPA.

```java
@Entity
public class Student {
    @Id
    private Long id;
}
```

## 🔗 API Endpoints

| HTTP Method | Endpoint                    | Description       |
| ----------- | --------------------------- | ----------------- |
| POST        | `/api/students/create`      | Create a student  |
| GET         | `/api/students/get/{id}`    | Get student by ID |
| GET         | `/api/students/getAll`      | Get all students  |
| PUT         | `/api/students/update/{id}` | Update student    |
| DELETE      | `/api/students/delete/{id}` | Delete student    |

## 📝 1. Create Student

### Request

```http
POST /api/students/create
```

### Request Body

```json
{
  "id": 1,
  "name": "Avinash",
  "age": 22,
  "email": "avinash@example.com",
  "rollNo": 101,
  "mobileNo": "9876543210"
}
```

### Response

```json
{
  "id": 1,
  "name": "Avinash",
  "age": 22,
  "email": "avinash@example.com",
  "rollNo": 101,
  "mobileNo": "9876543210"
}
```

## 🔍 2. Get Student By ID

```http
GET /api/students/get/1
```

Returns the student with the specified ID.

If the student does not exist:

```text
404 Not Found
```

## 📋 3. Get All Students

```http
GET /api/students/getAll
```

Returns a list of all students stored in the database.

If no students are available:

```text
404 Not Found
```

## ✏️ 4. Update Student

```http
PUT /api/students/update/1
```

### Request Body

```json
{
  "name": "Avinash Bachhav",
  "age": 23,
  "email": "avinash@example.com",
  "rollNo": 101,
  "mobileNo": "9876543210"
}
```

The service first checks whether the student exists and then updates the existing record.

## 🗑️ 5. Delete Student

```http
DELETE /api/students/delete/1
```

If the student exists, the record is permanently deleted from the database.

Response:

```text
Record Deleted.
```

If the student does not exist:

```text
404 Not Found
```

## 🗄️ Database Configuration

Create the MySQL database:

```sql
CREATE DATABASE crud_student_db;
```

Configure the database in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_student_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Replace `YOUR_PASSWORD` with your local MySQL password. Do not expose real credentials in a public GitHub repository.

## ▶️ How to Run

### 1. Clone the Repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

### 2. Open the Project

Open the project in IntelliJ IDEA or another Java IDE.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE crud_student_db;
```

Update your MySQL credentials in `application.properties`.

### 4. Run the Application

Run:

```text
CrudSpringBootApplication.java
```

The application starts on:

```text
http://localhost:8080
```

## 🧪 Testing

You can test the REST APIs using:

* Postman
* Insomnia
* Thunder Client

Example:

```http
GET http://localhost:8080/api/students/getAll
```

## 📚 Concepts Covered

This project helped me understand:

* **Spring Boot fundamentals**
* **REST API development**
* **CRUD operations**
* **Controller-Service-Repository architecture**
* **Dependency Injection**
* **Spring Data JPA**
* **Hibernate ORM**
* **JPA Entity Mapping**
* **MySQL integration**
* **`JpaRepository`**
* **HTTP methods – GET, POST, PUT, DELETE**
* **`@RequestBody`**
* **`@PathVariable`**
* **`ResponseEntity`**
* **HTTP status codes**
* **Optional handling**
* **Maven dependency management**
* **Basic Spring Boot testing**



## 👨‍💻 Author

**Avinash Bachhav**

MSc Computer Science | Java Backend Developer

### Skills

`Java` `Spring Boot` `Spring MVC` `Spring Data JPA` `Hibernate` `MySQL` `REST API` `Maven` `Git` `GitHub`

---

⭐ If you found this project useful, feel free to star the repository.
