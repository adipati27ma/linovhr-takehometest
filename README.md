# LinovHR Take Home Test

Take Home Test for the Full Stack Developer recruitment process at Lawencon Indonesia.

This project is a simple REST API for an Employee Leave Request system built using Spring Boot.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [Author](#author)

## Features

### Authentication
- JWT Authentication ✅
- Role-based authorization (Employee & Manager)

### Leave Request
- Create leave request
- Get employee leave history
- Get all employee leave requests (Manager)
- Approve leave request
- Reject leave request

### Validation Rules
- Leave quota validation
- Leave overlapping validation
- Start date and end date validation
- Approval status validation

### Technical Features
- Global exception handling ✅
- Database migration with Flyway ✅
- Dockerized PostgreSQL setup ✅

### Coming Soon
- Swagger / OpenAPI documentation
- Pagination support
- Transaction handling improvement
- Redis caching
- Unit testing & integration testing
- CI/CD pipeline setup

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Flyway
- Gradle
- Docker Compose

## Getting Started

### 1. Clone Repository

```bash
git clone https://github.com/adipati27ma/linovhr-takehometest.git
```

---

### 2. Configure Environment Variables

Rename:

```text
.env.example
```

to:

```text
.env
```

Then fill the environment variables:

```env
POSTGRES_DB=linovhr_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
```

---

### 3. Run PostgreSQL Database

```bash
docker compose up -d
```

---

### 4. Run Application

Using Gradle:

```bash
./gradlew bootRun
```

Application will run on:

```text
http://localhost:9712
```

## Project Structure

```text
src/main/java
├── config
├── controller
├── dto
├── entity
├── exception
├── helper
├── repository
├── security
├── service
└── validator
```

## API Documentation

Swagger/OpenAPI documentation will be added in future development.

Currently, API testing can be done using Postman or similar API tools.

## Author

[adipati27ma](https://github.com/adipati27ma)
