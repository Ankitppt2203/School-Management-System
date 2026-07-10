<div align="center">

# 🚀 School Management ERP

### A Production-Ready School ERP System built with Spring Boot & React

<p align="center">
Modern • Secure • Scalable • Enterprise Architecture
</p>

<img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk"/>
<img src="https://img.shields.io/badge/Spring_Boot-3.5-green?style=for-the-badge&logo=springboot"/>
<img src="https://img.shields.io/badge/React-18-blue?style=for-the-badge&logo=react"/>
<img src="https://img.shields.io/badge/TypeScript-5-blue?style=for-the-badge&logo=typescript"/>
<img src="https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql"/>
<img src="https://img.shields.io/badge/JWT-Security-red?style=for-the-badge"/>
<img src="https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker"/>
<img src="https://img.shields.io/github/license/ANKIT-PRAJAPATI/School-Management-ERP?style=for-the-badge"/>

</div>

---

# 🌟 Overview

School Management ERP is a full-stack enterprise application designed to simulate a real-world Education ERP platform.

Unlike traditional CRUD projects, this application focuses on:

- Enterprise Architecture
- Secure Authentication
- Modular Backend Design
- Modern React Dashboard
- Production Ready Code Structure
- REST API Development
- Database Relationships
- JWT Authentication
- Docker Support

The project is being developed as an industry-level portfolio project.

---

# ✨ Features

## 🔐 Authentication

- JWT Authentication
- Role Based Authorization
- Spring Security
- Stateless Session
- Secure API Access

---

## 👨‍🎓 Student Management

- Add Student
- Update Student
- Delete Student
- Search Students
- Pagination
- Sorting
- Department Mapping

---

## 👨‍🏫 Teacher Management

- Teacher CRUD
- Department Allocation
- Course Assignment

---

## 🏫 Department Module

- Department Management
- Student Mapping
- Teacher Mapping

---

## 📚 Course Module

- Create Courses
- Assign Teachers
- Student Enrollment

---

## 📅 Attendance

- Mark Attendance
- Daily Records
- Attendance History

---

## 📝 Examination

- Exam Management
- Result Generation
- Grades
- Marks

---

## 📊 Dashboard

- Student Analytics
- Teacher Analytics
- Attendance Reports
- Performance Charts

---

# 🏗️ Tech Stack

## Backend

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate
- JWT
- Maven
- REST APIs

---

## Frontend

- React
- TypeScript
- Vite
- Axios
- React Router
- Tailwind CSS
- Framer Motion

---

## Database

- PostgreSQL

---

## Dev Tools

- IntelliJ IDEA
- VS Code
- Postman
- Docker
- Git
- GitHub
- Swagger UI

---

# 📁 Project Structure

```
School-Management-ERP

├── backend
│
├── controller
├── service
├── repository
├── entity
├── DTO
├── mapper
├── security
├── exception
│
└── resources

frontend

├── components
├── pages
├── services
├── context
├── routes
├── types
├── hooks
└── assets
```

---

# 🔐 Authentication Flow

```
User Login

↓

Spring Security

↓

JWT Generation

↓

Frontend Stores Token

↓

Authorization Header

↓

Protected APIs
```

---

# 📦 REST APIs

### Authentication

```
POST /auth/login
```

---

### Students

```
GET /students

GET /students/{id}

POST /students

PUT /students/{id}

DELETE /students/{id}
```

---

### Teachers

```
GET /teachers

POST /teachers

PUT /teachers/{id}

DELETE /teachers/{id}
```

---

### Departments

```
GET /departments

POST /departments
```

---

### Courses

```
GET /courses

POST /courses
```

---

### Attendance

```
GET /attendance

POST /attendance
```

---

### Results

```
GET /results

POST /results
```

---

# 🛡️ Security

- JWT Authentication
- Role Based Authorization
- Password Validation
- Spring Security Filters
- Stateless Authentication

---

# 📊 Database

Main Relationships

```
Department
     │
     ├──────── Students
     │
     ├──────── Teachers
     │
     └──────── Courses

Student
     │
     ├──────── Attendance
     │
     └──────── Results
```

---

# 🚀 Future Roadmap

- Email Notifications
- Parent Portal
- Fees Management
- Timetable Module
- Library Module
- Hostel Module
- Transport Module
- Assignment Submission
- Online Examination
- AI Student Analytics
- AI Attendance Prediction
- Mobile Application
- Microservices Architecture
- Kubernetes Deployment
- CI/CD Pipeline

---

# 📷 Screenshots

### Dashboard

```
Coming Soon
```

### Student Module

```
Coming Soon
```

### Authentication

```
Coming Soon
```

---

# ⚙️ Getting Started

## Backend

```bash
git clone https://github.com/your-username/School-Management-ERP.git

cd backend

mvn spring-boot:run
```

---

## Frontend

```bash
cd frontend

npm install

npm run dev
```

---

## Database

Create PostgreSQL database

```
school_management
```

Update

```
application.properties
```

Run Spring Boot.

---

# 🤝 Contributing

Contributions are always welcome.

1. Fork Repository

2. Create Branch

3. Commit Changes

4. Push Branch

5. Create Pull Request

---

# ⭐ If you like this project

Give it a ⭐ on GitHub.

It motivates me to build more production-grade open-source projects.

---

# 👨‍💻 Author

**Ankit Prajapati**

Java Backend Developer | Full Stack Developer

LinkedIn:
> *(Add your LinkedIn URL)*

GitHub:
> *(Add your GitHub URL)*

---

<div align="center">

### ⭐ Built with Spring Boot • React • PostgreSQL • TypeScript ⭐

</div>
