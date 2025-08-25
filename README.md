# POLLeased — Polling & Surveys (Spring Boot + Angular)

A full‑stack polling application where users can create polls and vote in real time.

> TL;DR — **Backend** (Spring Boot): `mvn spring-boot:run` → `http://localhost:8080`  
> **Frontend** (Angular): `npm install && ng serve` → `http://localhost:4200`

---

## ✨ Core Features

- Create multi‑choice polls
- Vote anonymously

> Tech stack assumptions: **Spring Boot + Spring Data JPA + MySQL** for backend; **Angular** for the UI.

---

## 🧭 Architecture

```mermaid
flowchart LR
  subgraph Client (Angular)
    UI[Angular App] --> STOMP[STOMP client]
  end

  subgraph Server (Spring Boot)
    API[REST Controllers] --> Service[Services]
    Service --> Repo[JPA Repositories]
    Repo --> DB[(MySQL)]
  end
  
  UI -->|HTTP/JSON| API
```

**Key server paths:**

- REST: `/api/polls`, `/api/polls/vote`, `/api/polls/{id}`

---

## 🗄️ Data Model

```mermaid

  POLL {
    id int
    question string
  }

  POLL_OPTION {
    poll_id int
    pollOption string
    vote_count int
  }
  
```

---

## 🚀 Getting Started

### Prereqs
- **Java 21+**, **Maven 3.9+**
- **Node 18+**, **Angular CLI** (`npm i -g @angular/cli`)
- **MySQL**

### 1) Backend
```bash

cp src/main/resources/application.example.properties src/main/resources/application.properties

mvn spring-boot:run
```
Server default: `http://localhost:8080`

### 2) Frontend
```bash

npm install
ng serve
```
UI default: `http://localhost:4200`

---

## ⚙️ Configuration

`src/main/resources/application.properties`:
```properties
spring.application.name=POLLeased

# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/polleased
spring.datasource.username=DB_PASSWORD
spring.datasource.password=DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.config.import=optional:file:.env[.properties]
```

**CORS & Allowed Origins:** limit API origins in production.

---

## 📊 API

```
GET /api/polls
POST /api/polls
GET  /api/polls/{id}
POST /api/polls/vote
```

Responses use standard json for errors.

---

## 🧭 Development Plan (4–5 sprints)

**Sprint 1 — Foundations**
- Entities (User, Poll, Option, Vote) + REST CRUD + Bean validation
- Angular shell: auth flow, create/view/vote screens
- H2 for dev; MySQL profile ready; basic JWT Security

**Sprint 2 — Real‑time & UX**
- WebSocket/STOMP notifications for vote updates
- Live charts + optimistic UI; poll timers; empty/loading states
- Rate limiting; server‑side pagination & search

**Sprint 3 — Integrity & Admin**
- Audit log; close/archive; visibility controls; CAPTCHA toggle per poll
- Duplicate‑vote heuristics (rotating HMAC fingerprint); moderation endpoints
- CSV/JSON export; Slack webhook on close

**Sprint 4 — Advanced Voting Modes**
- Approval voting & multi‑select; **Ranked‑choice (IRV)** with server algorithm + tests
- Result breakdown & tie rules; downloadable report

**Sprint 5 — Scale & Ops**
- RabbitMQ STOMP relay (scaling WS), Redis session cache
- Micrometer + Prometheus + Grafana dashboard
- k6/Gatling load tests & published results

---

## 🤝 Contributing

Issues and PRs welcome. Please run `mvn -q -DskipTests=false verify` and `npm test` before opening a PR.

---


