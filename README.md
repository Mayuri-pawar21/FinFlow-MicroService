# 💳 FinFlow — Payment Settlement & Reconciliation Engine

A **microservices-based payment processing backend** designed to simulate real-world financial transaction processing, settlement, and reconciliation workflows.

FinFlow focuses on building a **secure, scalable, and modular backend architecture** using Java and Spring Boot.

---

## 🏗️ System Architecture

![FinFlow System Architecture](docs/architecture/finflow-system-architecture.png)

FinFlow follows a **microservices architecture** where each business capability is developed and deployed as an independent service.

The system consists of:

- **API Gateway** — Single entry point for client requests
- **Auth Service** — User registration, login, JWT authentication
- **Account Service** — Account and balance management
- **Transaction Service** — Payment and money transfer processing
- **Settlement Service** — Settlement creation and processing
- **Reconciliation Service** — Transaction and settlement reconciliation
- **Eureka Server** — Service discovery and registration

---

## 📌 About FinFlow

FinFlow is a backend system designed to model a simplified **payment processing and settlement platform**.

The project demonstrates how modern financial systems can be built using **Spring Boot Microservices**, with separate services responsible for authentication, accounts, transactions, settlements, and reconciliation.

The system supports a complete payment workflow:

**Authentication → Account → Transaction → Settlement → Reconciliation**

---

## 🎯 Vision

To build a secure and scalable distributed payment processing platform that demonstrates real-world backend engineering concepts such as:

- Microservices Architecture
- Secure Authentication & Authorization
- Transaction Processing
- Settlement Management
- Financial Reconciliation
- Service Discovery
- Inter-Service Communication

---

## 💡 Why FinFlow?

Financial systems require more than simply transferring money.

They need to ensure:

- Secure user authentication
- Role-based authorization
- Accurate transaction processing
- Reliable account balance updates
- Settlement tracking
- Transaction and settlement reconciliation
- Communication between independent services

FinFlow brings these concepts together into a single distributed backend system.

---

## 🎯 Project Objectives

- Build a modular **microservices-based payment backend**
- Implement secure authentication using **JWT**
- Implement **role-based authorization**
- Manage accounts and balances
- Process financial transactions securely
- Implement settlement processing
- Implement transaction reconciliation
- Implement service discovery using **Eureka**
- Implement inter-service communication
- Demonstrate an end-to-end payment workflow

---

## 🧠 Design Philosophy

The project follows a **layered architecture** within each microservice.

### Core Design Principles

- **Microservices Architecture**
- **Layered Architecture**
- **DTO-based communication**
- **Repository Pattern**
- **Service Layer for business logic**
- **Global Exception Handling**
- **UUID-based entity identification**
- **BigDecimal for financial calculations**
- **Input Validation**
- **Constructor-based Dependency Injection**
- **Stateless JWT Authentication**

---

## 🛠️ Tech Stack

### Backend

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- Maven

### Microservices & Cloud

- Spring Cloud Gateway
- Netflix Eureka
- OpenFeign
- Spring Cloud LoadBalancer
- RestClient

### Security

- JWT
- BCrypt
- Role-Based Access Control

### Database

- MySQL

### Testing & Development

- JUnit
- Postman
- IntelliJ IDEA
- Git & GitHub

---

## 📂 Project Structure

```text
FinFlow - microservices
│
├── AuthService/
│   └── AuthService/
│
├── account-service/
│   └── account-service/
│
├── apigateway/
│   └── apigateway/
│
├── discovery-server/
│   └── discovery-server/
│
├── transaction-services/
│   └── transaction-services/
│
├── settlement-service/
│   └── settlement-service/
│
├── reconciliation-service/
│   └── reconciliation-service/
│
├── docs/
│   └── architecture/
│       └── finflow-system-architecture.png
│
├── .gitignore
└── README.md
```

---

## 🔐 Key Features

### 🔑 Authentication & Authorization

- User registration
- User login
- BCrypt password encryption
- JWT token generation
- JWT validation
- Role-based authorization
- Protected APIs

### 🏦 Account Management

- Create accounts
- Retrieve account details
- Update account information
- Balance management
- Account status validation

### 💸 Transaction Processing

- Account-to-account transfers
- Sender and receiver validation
- Balance validation
- Currency validation
- Transaction status tracking
- Transaction reference generation

### 💰 Settlement Processing

- Create settlements
- Validate transaction details
- Process settlements
- Settlement status tracking
- Duplicate settlement prevention

### 🔍 Reconciliation

- Compare transaction and settlement details
- Calculate differences
- Identify matched and mismatched records
- Track reconciliation status

### 🌐 Service Discovery

Services register themselves with **Eureka Server**, allowing other services to discover them dynamically.

### 🔄 Inter-Service Communication

The project demonstrates synchronous communication between microservices using:

- **RestClient**
- **OpenFeign**
- **Eureka Service Discovery**

### 🚪 API Gateway

The API Gateway provides a single entry point for client requests and handles:

- Request routing
- JWT validation
- Authentication forwarding
- Service discovery-based routing

---

## 🔄 End-to-End Payment Flow

```text
Client
   │
   ▼
API Gateway
   │
   ▼
Authentication
   │
   ▼
Transaction Service
   │
   ├──► Account Service
   │       │
   │       └── Update balances
   │
   ▼
Settlement Service
   │
   ▼
Reconciliation Service
```

A typical transaction follows:

```text
User Login
    ↓
JWT Generated
    ↓
Transaction Request
    ↓
Account Validation
    ↓
Balance Update
    ↓
Transaction Created
    ↓
Settlement Created
    ↓
Settlement Processed
    ↓
Reconciliation
    ↓
MATCHED / MISMATCH
```

---

## 📊 Project Status

FinFlow currently includes the following implemented modules:

- ✅ JWT Authentication & Authorization
- ✅ Account Management
- ✅ Transaction Processing
- ✅ Settlement Processing
- ✅ Reconciliation
- ✅ API Gateway
- ✅ Eureka Service Discovery
- ✅ Inter-Service Communication
- ✅ End-to-End Payment Workflow

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 21
- Maven
- MySQL
- Git
- Postman

### Clone the Repository

```bash
git clone https://github.com/Mayuri-pawar21/FinFlow-Microservices.git
```

### Navigate to the Project

```bash
cd FinFlow-Microservices
```

### Database Setup

Create the MySQL database:

```sql
CREATE DATABASE finflow;
```

Configure the database credentials in the respective service `application.properties` files.

### Start the Services

Start the services in the following order:

```text
1. Discovery Server
2. Auth Service
3. Account Service
4. Transaction Service
5. Settlement Service
6. Reconciliation Service
7. API Gateway
```

The API Gateway acts as the main entry point for API requests:

```text
http://localhost:8080
```

---

## 🗺️ Roadmap

- [x] Microservices Architecture
- [x] JWT Authentication
- [x] Transaction Processing
- [x] Settlement Engine
- [x] Reconciliation
- [x] API Gateway
- [x] Service Discovery
- [x] Inter-Service Communication
- [ ] Kafka Event Streaming
- [ ] Docker Containerization
- [ ] Swagger / OpenAPI Documentation
- [ ] Resilience4j
- [ ] Fraud Detection
- [ ] Kubernetes Deployment

---

## 👩‍💻 Author

**Mayuri Pawar**

B.E. Electronics & Computer Engineering  
Pune Institute of Computer Technology (PICT)

---

⭐ If you find this project interesting, feel free to explore the repository and connect with me.
