---

# Store Management – Event-Driven Microservices E-commerce Backend

This project serves as a foundational backend for an e-commerce platform, utilizing an event-driven microservices architecture. It leverages Docker for containerization and LocalStack to emulate AWS services locally, facilitating efficient development and testing.

## 🧩 Architecture Overview

The system is composed of several microservices, each responsible for specific functionalities:

- **API Gateway**: Routes client requests to appropriate services.
- **Auth Service**: Handles user authentication and authorization.
- **User Service**: Manages user-related data and operations.
- **Billing Service**: Handles billing and payment logic.
- **Analytics Service**: Collects and processes analytics data.

All services communicate using **gRPC** to ensure high performance and scalability.

## 🛠️ Technologies Used

- **Language**: Java
- **Build Tool**: Maven
- **Communication**: gRPC
- **Containerization**: Docker
- **AWS Emulation**: LocalStack
- **[Database]**: *[Add your DB, e.g., PostgreSQL]*

## 🚀 Getting Started

### Prerequisites

- Docker
- Java 21
- Maven

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/madhuka2002/store-management.git
   cd store-management
   ```

2. **Build all services using Maven**:
   ```bash
   mvn clean install
   ```

3. **Start services using Docker Compose**:
   ```bash
   docker-compose up --build
   ```

Make sure Docker and LocalStack are running before starting the services.

## 📁 Project Structure

```plaintext
store-management/
├── api-gateway/           
├── auth-service/          
├── user-service/          
├── billing-service/       
├── analytics-service/     
├── grpc-requests/         
├── infrastructure/        
├── integration-tests/     
├── .gitignore             
├── README.md              
└── docker-compose.yml     
```

## 🧪 Testing

To run integration tests:

```bash
cd integration-tests
mvn test
```

Ensure all services are running before executing tests.
