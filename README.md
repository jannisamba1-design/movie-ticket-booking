# 🎬 Movie Ticket Booking Platform

This project is a backend-only, microservices-based Movie Ticket Booking Platform,
designed and implemented as an architecture-focused exercise.

The goal is to demonstrate:
- System design (HLD & LLD)
- Microservice boundaries
- Transactional consistency
- Scalability and reliability patterns
- Cloud-native deployment readiness (AWS EKS)

---

## 🧩 Services Overview

| Service | Responsibility |
|------|----------------|
| API Gateway | Routing, authentication, rate limiting |
| Show Service | Movies, theatres, screens, show timings |
| Inventory Service | Seat availability & seat locking |
| Booking Service | Ticket booking & orchestration |
| Auth Service (design) | JWT-based authentication |

---

## 🧱 High-Level Architecture

- Microservices architecture
- Database-per-service
- Synchronous REST for reads
- Async messaging (Kafka) for events
- Redis for seat locking
- Deployed on AWS EKS

---

## 🔁 Implemented Flows

### ✅ Read Flow
Browse shows by movie, city, and date.

### ✅ Write Flow
Book seats with:
- Seat locking
- Idempotency
- Transaction management

---

## 🔐 Security
- JWT-based authentication
- Role-based authorization
- OWASP Top 10 considerations

---

## 📈 Scalability & Reliability
- Stateless services
- Horizontal scaling
- Redis for hot data
- Blue/Green deployments

---

## ☁️ Infrastructure
- Docker
- Jenkins CI
- AWS ECR
- AWS EKS

---

## 🚧 Out of Scope (Intentional)
- UI
- Real payment gateway
- AI recommendations
