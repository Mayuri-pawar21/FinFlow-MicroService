# 💳 FinFlow

> A production-inspired distributed payment processing platform built using Java 21, Spring Boot, and MySQL.

<p align="center">
    <img src="docs/architecture/finflow-system-architecture.png" width="100%">
</p>

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-green)
![Microservices](https://img.shields.io/badge/Architecture-Microservices-purple)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![REST API](https://img.shields.io/badge/API-REST-success)

</p>

---

## 📖 About

FinFlow is a **production-inspired distributed payment processing platform** designed to simulate how modern financial systems process digital payments.

The platform is built using **Spring Boot Microservices**, with independent services responsible for authentication, account management, transaction processing, settlement, and reconciliation.

The project focuses on **clean architecture, secure backend development, service discovery, inter-service communication, and real-world payment workflows**.

---

## ✨ Vision

The objective of FinFlow is to build a modular and scalable distributed payment processing platform while applying **clean architecture, secure communication, and enterprise backend development practices**.

---

## 💡 Why FinFlow?

Most payment processing projects focus primarily on CRUD operations.

FinFlow was created to explore how distributed payment platforms are designed by implementing concepts such as **microservices architecture, JWT authentication, transaction processing, service discovery, settlement, reconciliation, and inter-service communication**.

The objective is not only to build APIs, but also to understand the engineering principles behind modern financial systems.

---

## 🎯 Project Objectives

The primary goal of FinFlow is to strengthen backend engineering skills by designing and implementing a production-inspired distributed payment platform.

Key objectives include:

- Build scalable RESTful APIs
- Follow Clean Layered Architecture
- Implement secure authentication and authorization
- Design modular microservices
- Simulate real-world payment workflows
- Implement service discovery and inter-service communication
- Practice maintainable backend design and documentation

---

## 🏛️ Design Philosophy

FinFlow is designed by following software engineering principles that emphasize **maintainability, scalability, security, and clean architecture**.

### Core Design Decisions

- **Microservices Architecture** – Separates major business capabilities into independently manageable services.
- **Layered Architecture** – Separates responsibilities into Controller, Service, Mapper, and Repository layers.
- **DTO Pattern** – Keeps API contracts independent from database entities.
- **Repository Pattern** – Abstracts database access using Spring Data JPA.
- **Business Logic in Service Layer** – Keeps controllers lightweight and focused on request handling.
- **Global Exception Handling** – Provides consistent API error responses.
- **JWT Authentication** – Enables stateless authentication across protected services.
- **Role-Based Authorization** – Controls access to APIs based on user roles.
- **UUID Primary Keys** – Provides globally unique identifiers suitable for distributed systems.
- **BigDecimal for Monetary Values** – Prevents floating-point precision errors in financial calculations.
- **Bean Validation** – Ensures invalid requests are rejected before reaching business logic.
- **Constructor Injection** – Promotes loose coupling and easier testing.

---

## 📚 Documentation

- 📐 [Architecture](docs/architecture.md)
- 🗄️ [Database Design](docs/database-design.md)
- 📚 [API Reference](docs/api-reference.md)
- ⚙️ [System Design](docs/system-design.md)
- 🚀 [Deployment Guide](docs/deployment.md)

---

## 🛠️ Tech Stack

| Technology           | Version                     |
| -------------------- | --------------------------- |
| Java                 | 21                          |
| Spring Boot          | 4.x                         |
| Spring Security      | JWT                         |
| MySQL                | 8.x                         |
| Spring Cloud Gateway | Gateway                     |
| Eureka               | Service Discovery           |
| OpenFeign            | Inter-Service Communication |
| RestClient           | Inter-Service Communication |
| Hibernate            | ORM                         |
| Maven                | Build Tool                  |
| Git                  | Version Control             |
| Postman              | API Testing                 |

---

## 📂 Project Structure

```text
FinFlow
│
├── AuthService
│   └── AuthService
│
├── account-service
│   └── account-service
│
├── apigateway
│   └── apigateway
│
├── discovery-server
│   └── discovery-server
│
├── transaction-services
│   └── transaction-services
│
├── settlement-service
│   └── settlement-service
│
├── reconciliation-service
│   └── reconciliation-service
│
├── docs
│   └── architecture
│       └── finflow-system-architecture.png
│
└── README.md
```

---

## 🚧 Project Status

FinFlow is actively being developed.

Current implementation includes:

- ✅ JWT Authentication & Authorization
- ✅ Account Management
- ✅ Transaction Processing
- ✅ Settlement Processing
- ✅ Reconciliation
- ✅ API Gateway
- ✅ Eureka Service Discovery
- ✅ Inter-Service Communication
- ✅ End-to-End Payment Workflow

The core payment workflow has been implemented and tested across multiple microservices.

---

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/Mayuri-pawar21/FinFlow-Microservices.git
```

### Navigate to the Project

```bash
cd FinFlow-Microservices
```

### Configure MySQL

Create a database named:

```sql
CREATE DATABASE finflow;
```

Update the respective `application.properties` files with your database credentials.

### Run the Services

Start the services in the following order:

```text
Discovery Server
      ↓
Auth / Account / Transaction / Settlement / Reconciliation
      ↓
API Gateway
```

The API Gateway will be available at:

```text
http://localhost:8080
```

---

## 🗺️ Roadmap

- ✅ Account Management
- ✅ JWT Authentication & Authorization
- ✅ Transaction Processing
- ✅ Settlement Engine
- ✅ Reconciliation
- ✅ API Gateway
- ✅ Service Discovery
- 🔄 Kafka Event Streaming
- 🔄 Docker
- 🔄 Swagger / OpenAPI
- 🔄 Resilience4j
- 🔄 Fraud Detection
- 🔄 Kubernetes

---

## 👩‍💻 Author

**Mayuri Pawar**

B.E. Electronics & Computer Engineering  
Pune Institute of Computer Technology (PICT)

Passionate about **Java Backend Development, Distributed Systems, and System Design**.
