# 🤖 HumanChain AI Safety Incident Log API

A Spring Boot-based REST API for managing incident logs. This project provides a robust backend system for tracking and managing AI safety incidents to support responsible AI development and compliance.

**Visit now →** [https://humanchain-ai-safety.onrender.com](https://humanchain-ai-safety.onrender.com)


---

## ✅ Prerequisites

Ensure you have the following installed:
- Java 17 or higher
- Git

---
## 📝 Note

**🚀 Everything you need to run this project is already configured!**
-  The repository includes all required files — including `application.properties`.
-  No manual setup is needed for the database or environment.
-  Just clone the project, ensure your system meets the Prerequisites, and follow the ⚙️ Project Setup instructions.
-  The H2 database auto-initializes with schema and sample data at startup.
   
---

## ⚙️ Project Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/kalyanram003/HumanChain-Ai-Safety.git
   cd Incident-API
   ```

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`

### 💾 Database Setup
- No manual setup required

### Sample Data
The database is automatically populated with 3 sample incidents:
1. Model Hallucination in Medical Diagnosis
2. Bias in Hiring Algorithm
3. Prompt Injection Vulnerability

---
### Endpoints

| HTTP Method | Endpoint | Description |
|------------|----------|-------------|
| GET | `/` | Welcome message and API documentation |
| GET | `/incidents` | Fetch all incidents |
| POST | `/incidents` | Create a new incident |
| GET | `/incidents/<int:id>` | Fetch a specific incident by its ID |
| DELETE | `/incidents/<int:id>` | Delete a specific incident by its ID |

---

### Example Requests

1. **Create Incident**
   ```bash
   # Using curl
   curl -X POST http://localhost:8080/incidents \
   -H "Content-Type: application/json" \
   -d '{"title":"Server Down","description":"Main server is not responding","severity":"High"}'
   ```
   ```bash
   # Using PowerShell
   $body = @{
       title = "Server Down"
       description = "Main server is not responding"
       severity = "High"
   } | ConvertTo-Json
   Invoke-RestMethod -Uri "http://localhost:8080/incidents" -Method Post -Body $body -  ContentType "application/json"
   ```
2. **Get All Incidents**
   ```bash
    # Using curl
    curl http://localhost:8080/incidents
   ```
   ```bash
    # Using PowerShell
    Invoke-RestMethod -Uri "http://localhost:8080/incidents" -Method Get  
   ```
3. **Get Incident by ID**
   ```bash
    # Using curl
    curl http://localhost:8080/incidents/1
   ```
   ```bash
    # Using PowerShell
    Invoke-RestMethod -Uri "http://localhost:8080/incidents/1" -Method Get

   ```

4. **Delete Incident**
   ```bash
    # Using curl
    curl -X DELETE http://localhost:8080/incidents/1
   ```
   ```bash
    # Using PowerShell
    Invoke-RestMethod -Uri "http://localhost:8080/incidents/1" -Method Delete

   ```
---

## 📚 API Documentation

### Base URL
`http://localhost:8080`

### Endpoints

#### 1. Get All Incidents
```bash
GET http://localhost:8080/incidents
```

**Response (200 OK)**
```json
[
  {
    "id": 1,
    "title": "Model Hallucination in Medical Diagnosis",
    "description": "AI model provided incorrect medical diagnosis with high confidence...",
    "severity": "High",
    "reportedAt": "2024-04-01T10:00:00"
  },
]
```

#### 2. Create New Incident
```bash
POST http://localhost:8080/incidents
```

**Request Body**
```json
{
  "title": "New Safety Concern",
  "description": "Detailed description of the incident",
  "severity": "Medium"
}
```

**Response (201 Created)**
```json
{
  "id": 4,
  "title": "New Safety Concern",
  "description": "Detailed description of the incident",
  "severity": "Medium",
  "reportedAt": "2024-04-04T15:30:00"
}
```

#### 3. Get Incident by ID
```bash
GET http://localhost:8080/incidents/{id}
```

**Response (200 OK)**
```json
{
  "id": 1,
  "title": "Model Hallucination in Medical Diagnosis",
  "description": "AI model provided incorrect medical diagnosis...",
  "severity": "High",
  "reportedAt": "2024-04-01T10:00:00"
}
```

#### 4. Delete Incident
```bash
DELETE /incidents/{id}
```

**Response (200 OK)**
```json
"Incident deleted successfully"
```

### Error Responses

#### 400 Bad Request
```json
{
  "error": "Severity must be Low, Medium, or High"
}
```

#### 404 Not Found
```json
{
  "error": "Incident not found"
}
```

---

## 🔍 Design Decisions

1. **Technology Choice**
   - Spring Boot for robust enterprise-grade API development
   - H2 in-memory database for simplicity and quick setup
   - JPA/Hibernate for efficient data persistence

2. **Validation**
   - Implemented severity validation (Low, Medium, High)
   - Required field validation for title and description
   - Automatic timestamp generation for reportedAt

3. **Error Handling**
   - Custom error responses for invalid requests
   - Proper HTTP status codes
   - Clear error messages




