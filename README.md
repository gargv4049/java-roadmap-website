# Java Roadmap Website

This is a complete Java learning roadmap website with:

- HTML, CSS and JavaScript frontend
- Java Spring Boot backend
- MySQL database
- REST APIs
- Roadmap phases and topics
- Progress tracking
- Add topic feature

## Tech Stack

- Java 21
- Spring Boot 3.5.15
- Spring Web
- Spring Data JPA
- MySQL
- HTML/CSS/JavaScript

## Project Structure

```text
java-roadmap-website
├── pom.xml
├── src/main/java/com/vivek/javaroadmap
│   ├── JavaRoadmapApplication.java
│   ├── config/DataSeeder.java
│   ├── controller
│   ├── dto
│   ├── model
│   ├── repository
│   └── service
└── src/main/resources
    ├── application.properties
    └── static
        ├── index.html
        ├── style.css
        └── app.js
```

## How to Run

### Step 1: Start MySQL

If you use XAMPP:

1. Open XAMPP
2. Start Apache
3. Start MySQL

### Step 2: Create Database

Open phpMyAdmin or MySQL command line and run:

```sql
CREATE DATABASE java_roadmap_db;
```

The project also uses `createDatabaseIfNotExist=true`, so it can create the database automatically if MySQL permissions allow it.

### Step 3: Check Database Username and Password

Open this file:

```text
src/main/resources/application.properties
```

Default config:

```properties
spring.datasource.username=root
spring.datasource.password=
```

If your MySQL password is different, update it.

### Step 4: Run Project

Open terminal inside project folder:

```bash
mvn spring-boot:run
```

### Step 5: Open Website

Open browser:

```text
http://localhost:8080
```

## API Endpoints

### Get all roadmap phases

```http
GET /api/roadmap/phases
```

### Add phase

```http
POST /api/roadmap/phases
```

Body:

```json
{
  "phaseOrder": 6,
  "title": "Interview Preparation",
  "level": "Final",
  "duration": "1 Month",
  "goal": "Prepare Core Java, DSA and backend interview questions.",
  "description": "Mock interviews, resume and GitHub preparation."
}
```

### Add topic

```http
POST /api/roadmap/topics
```

Body:

```json
{
  "phaseId": 1,
  "topicOrder": 7,
  "name": "Pattern Programs",
  "description": "Star patterns, number patterns and pyramid patterns.",
  "projectBased": false
}
```

### Toggle topic progress

```http
POST /api/progress/toggle
```

Body:

```json
{
  "learnerName": "Vivek",
  "topicId": 1
}
```

### Get progress

```http
GET /api/progress?learnerName=Vivek
```

## Beginner Explanation

This website follows MVC-style backend structure:

- Model: Database tables/entities
- Repository: Database operations
- Service: Business logic
- Controller: API endpoints
- Static folder: Frontend website

## Features

1. Roadmap phases show automatically from database
2. Default Java roadmap data loads on first run
3. User can mark topics as completed
4. Progress percentage updates automatically
5. New topics can be added from website
6. Backend APIs support CRUD operations
