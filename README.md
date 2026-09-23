# 💳 FinFlow

> A production-inspired distributed payment processing platform built using Java 21, Spring Boot, and MySQL.

<p align="center">
    <img src="docs/architecture/finflow-system-architecture.png" width="100%">
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-yellow)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![REST API](https://img.shields.io/badge/API-REST-success)

</p>

---

## 📖 About

FinFlow is a **production-inspired distributed payment processing platform** designed to simulate how modern financial systems such as **Stripe, Razorpay, and PhonePe** process digital payments.

Rather than focusing only on CRUD operations, the project emphasizes **clean architecture, enterprise backend development practices, scalable system design, and real-world payment workflows**.

The project is being developed incrementally, with each module designed to mirror the responsibilities and architectural patterns commonly found in modern payment systems.
---

## ✨ Vision

The objective of FinFlow is to evolve into a complete distributed payment processing platform inspired by systems such as Stripe, Razorpay, and PhonePe while following clean architecture and industry best practices.

---
## 💡 Why FinFlow?

Most payment processing projects available online focus primarily on implementing CRUD operations.

FinFlow was created to explore how enterprise payment platforms are designed by implementing concepts such as layered architecture, transaction processing, ledger systems, idempotency, settlement, event-driven communication, and scalable backend design.

The objective is not only to build APIs, but also to understand the engineering principles behind modern financial systems.

---
## 🎯 Project Objectives

The primary goal of FinFlow is to strengthen backend engineering skills by designing and implementing a production-inspired payment platform.

Key objectives include:

- Build scalable RESTful APIs
- Follow Clean Layered Architecture
- Apply SOLID Principles
- Design maintainable backend systems
- Simulate real-world payment workflows
- Learn distributed system fundamentals
- Improve software design and documentation practices

 ---
 ## 🏛️ Design Philosophy

FinFlow is designed by following software engineering principles that emphasize maintainability, scalability, and clean architecture over rapid feature development.

### Core Design Decisions

- **Layered Architecture** – Separates responsibilities into Controller, Service, Mapper, and Repository layers.
- **DTO Pattern** – Keeps API contracts independent from database entities.
- **Repository Pattern** – Abstracts database access using Spring Data JPA.
- **Business Logic in Service Layer** – Keeps controllers lightweight and focused on request handling.
- **Global Exception Handling** – Provides consistent and meaningful API error responses.
- **UUID Primary Keys** – Enables globally unique identifiers suitable for distributed systems.
- **BigDecimal for Monetary Values** – Prevents floating-point precision errors in financial calculations.
- **Bean Validation** – Ensures invalid requests are rejected before reaching business logic.
- **Constructor Injection** – Promotes immutability, easier testing, and loose coupling.

These decisions are inspired by enterprise backend development practices commonly used in modern financial systems.

 ---
## 📚 Documentation

- 📐 [Architecture](docs/architecture.md)
- 🗄️ [Database Design](docs/database-design.md)
- 📚 [API Reference](docs/api-reference.md)
- ⚙️ [System Design](docs/system-design.md)
- 🚀 [Deployment Guide](docs/deployment.md)
---

## 🛠️ Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.x |
| MySQL | 8.x |
| Hibernate | ORM |
| Maven | Build Tool |
| Git | Version Control |
| Postman | API Testing |

---
## 📂 Project Structure

```text
FinFlow
│
├── docs
│   ├── architecture
│   ├── architecture.md
│   ├── api-reference.md
│   ├── database-design.md
│   ├── deployment.md
│   └── system-design.md
│
├── postman
│
├── transaction-service
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── exception
│   ├── mapper
│   ├── repository
│   ├── service
│   └── config
│
└── README.md
```
---

## 🚧 Project Status

FinFlow is actively being developed.

Current implementation includes the Account Management module with layered architecture, validation, persistence, and centralized exception handling.

Additional modules will be introduced incrementally following production-oriented design principles.

---
## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/Mayuri-pawar21/FinFlow.git
```

### Navigate to the Project

```bash
cd FinFlow/transaction-service
```

### Configure MySQL

Create a database named:

```sql
CREATE DATABASE finflow;
```

Update `application.properties` with your database credentials.

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```
---
## 🗺️ Roadmap

- ✅ Account Management
- 🔄 Transaction Module
- 📒 Double Entry Ledger
- ⚡ Kafka Event Streaming
- 🏦 Settlement Engine
- 🛡️ Fraud Detection
- 🐳 Docker
- ☸️ Kubernetes
- ☁️ Microservices
---

## 👩‍💻 Author

**Mayuri Pawar**

B.Tech Electronics & Computer Engineering

Passionate about Java Backend Development, Distributed Systems, and System Design.
