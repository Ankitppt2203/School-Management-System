# 🎓 School Management System

A comprehensive School Management System backend built using Spring Boot, PostgreSQL, Spring Security, JWT Authentication, and JPA/Hibernate.

This project provides REST APIs for managing students, teachers, departments, courses, attendance, exams, results, and report cards while implementing secure JWT-based authentication and authorization.

---

## 🚀 Features

### Authentication & Security

* JWT Authentication
* Spring Security
* Protected REST APIs
* User Login System
* Role field support for future RBAC implementation

### Student Management

* Add Student
* Update Student
* Delete Student
* Get Student by ID
* Get All Students
* Search Students
* Pagination & Sorting

### Department Management

* Create Department
* View Departments
* Student-Department Relationship
* Teacher-Department Relationship

### Teacher Management

* Add Teacher
* Update Teacher
* Delete Teacher
* Search Teachers
* Department Assignment

### Course Management

* Create Course
* Assign Course to Students
* Many-to-Many Relationship

### Attendance Management

* Mark Attendance
* View Attendance Records
* Attendance by Student

### Exam Management

* Create Exams
* Manage Exam Details
* Maximum Marks Configuration

### Result Management

* Add Student Results
* Automatic Grade Calculation
* Percentage Calculation
* Report Card Generation

### Validation & Exception Handling

* DTO Validation
* Global Exception Handling
* Custom Exceptions
* Clean Error Responses

### API Documentation

* Swagger UI
* OpenAPI Documentation

---

## 🏗️ Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* PostgreSQL

### Authentication

* JWT (JSON Web Token)

### Build Tool

* Maven

### Documentation

* Swagger / OpenAPI

### Version Control

* Git
* GitHub

---

## 📂 Project Structure

src/main/java/com/ankit/school_management

├── controller

├── service

├── repository

├── entity

├── DTO

├── security

├── exception

└── mapper

---

## 🔗 Entity Relationships

### Department ↔ Students

* One Department can have many Students.
* One Student belongs to one Department.

### Department ↔ Teachers

* One Department can have many Teachers.
* One Teacher belongs to one Department.

### Student ↔ Course

* Many-to-Many Relationship

### Student ↔ Attendance

* One-to-Many Relationship

### Student ↔ Result

* One-to-Many Relationship

### Exam ↔ Result

* One-to-Many Relationship

---

## 🔐 Authentication Flow

1. User logs in using username and password.
2. JWT token is generated.
3. Client sends token in Authorization header.

Example:

Authorization: Bearer <JWT_TOKEN>

4. JwtFilter validates the token.
5. Protected APIs become accessible.

---

## 📌 Main APIs

### Authentication

POST /auth/login

### Students

GET /students

GET /students/{id}

POST /students

PUT /students/{id}

DELETE /students/{id}

### Teachers

GET /teachers

POST /teachers

### Departments

GET /departments

POST /departments

### Courses

GET /courses

POST /courses

### Attendance

GET /attendance

POST /attendance

### Exams

GET /exams

POST /exams

### Results

GET /results

POST /results

GET /results/student/{studentId}/report

---

## 🧪 API Testing

Swagger UI:

http://localhost:8080/swagger-ui/index.html

---

## 🎯 Future Enhancements

### Security

* Role-Based Access Control (ADMIN, TEACHER, STUDENT, PARENT)
* BCrypt Password Encryption
* Refresh Tokens

### ERP Features

* Fees Management
* Timetable Management
* Parent Portal
* Teacher Portal
* Homework Management
* Leave Management
* Notifications

### Advanced Features

* PDF Report Card Generation
* Dashboard Analytics
* File Uploads
* Library Management
* Audit Logs
* Multi-School Support (SaaS ERP)

---

## 📈 Learning Outcomes

This project helped in understanding:

* REST API Development
* Spring Boot Architecture
* DTO Pattern
* JPA Relationships
* Exception Handling
* Validation
* JWT Authentication
* Spring Security
* PostgreSQL Integration
* Git & GitHub Workflow

---

## 👨‍💻 Author

Ankit Prajapati

GitHub:
https://github.com/Ankitppt2203

Project:
School Management System Backend
