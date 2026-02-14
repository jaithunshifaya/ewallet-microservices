# 💳 eWallet Microservices Architecture

A distributed eWallet system built using Spring Boot microservices architecture.  
The system supports wallet management, merchant payments, transaction ledger tracking, and real-time notifications.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- SLF4J Logging
- Maven
- Swagger UI

---

## 🏗 Microservices Overview

| Service | Port | Responsibility |
|----------|------|----------------|
| Wallet Service | 8081 | Manage customer wallet balance |
| Merchant Service | 8082 | Handle merchant credits |
| Payment Service | 8080 | Orchestrates transactions |
| Notification Service | 8083 | Logs payment notifications |

---

## 🔁 Payment Flow

1. Validate wallet balance  
2. Deduct wallet amount  
3. Credit merchant (after 2% fee deduction)  
4. Save transaction in ledger  
5. Trigger notification service  

---

## 🗄 Database

PostgreSQL Database: `ewallet`

Tables:
- wallet
- merchant
- transaction_ledger
- notification_log

---

## ▶️ How To Run

1. Create PostgreSQL database:

 `CREATE DATABASE ewallet;`

2. Update application.properties with your DB credentials.

3. Run services in this order:

- Wallet Service

- Merchant Service

- Notification Service

- Payment Service

4. Access Swagger UI:

http://localhost:8080/swagger-ui/index.html

http://localhost:8081/swagger-ui/index.html

http://localhost:8082/swagger-ui/index.html

http://localhost:8083/swagger-ui/index.html

---

## 📌 Key Features

- Distributed microservices architecture

- Transactional consistency using @Transactional

- Inter-service communication using Feign Client

- Centralized transaction ledger

- SLF4J logging for observability

---

## 📬 Sample API Request

### Initiate Payment

**POST** `/payment/initiate`

```json
{
  "customerId": 1,
  "merchantId": 1,
  "amount": 100,
  "currency": "INR"
}
