# Faculty Management System

A modern, microservices-based faculty management system built with Spring Boot and React.

![Java](https://img.shields.io/badge/Java-17-red.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.12-brightgreen.svg)
![React](https://img.shields.io/badge/React-18.2.0-blue.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)

## 🚀 Features

- **Microservices Architecture**
  - Service Discovery with Eureka
  - API Gateway for routing
  - Separate services for Students, Teachers, Admin, Notes, and Modules
  - Event-driven communication

- **Modern Frontend**
  - React 18 with modern hooks
  - Responsive design with Bootstrap 5
  - Material Design components
  - Client-side routing
  - State management with Context API

- **Backend Services**
  - RESTful APIs
  - JPA for data persistence
  - MySQL database
  - Secure authentication
  - Role-based access control

## 🏗️ Architecture

```
faculty-management-app/
├── frontend/                 # React frontend application
│   ├── src/
│   ├── public/
│   └── package.json
│
├── backend/                  # Microservices backend
│   ├── Eureka-server/       # Service discovery
│   ├── Gateway/             # API Gateway
│   ├── admin-service/       # Admin management
│   ├── etudiant-service/    # Student management
│   ├── enseignant-service/  # Teacher management
│   ├── Notes-service/       # Grade management
│   └── Module-service/      # Course management
│
└── README.md
```

## 🛠️ Technology Stack

### Frontend
- React 18
- React Router v6
- Bootstrap 5
- Material Design
- Axios
- Styled Components

### Backend
- Java 17
- Spring Boot 2.7.12
- Spring Cloud
- Spring Data JPA
- MySQL 8
- Maven
- Lombok

## 🚀 Getting Started

### Prerequisites
- Java 17
- Node.js 16+
- MySQL 8
- Maven 3.6+

### Backend Setup
1. Start MySQL server
2. Start Eureka Server:
   ```bash
   cd backend/Eureka-server
   mvn spring-boot:run
   ```
3. Start API Gateway:
   ```bash
   cd backend/Gateway
   mvn spring-boot:run
   ```
4. Start other microservices:
   ```bash
   cd backend/[service-name]
   mvn spring-boot:run
   ```

### Frontend Setup
1. Install dependencies:
   ```bash
   cd frontend
   npm install
   ```
2. Start development server:
   ```bash
   npm start
   ```

## 📚 API Documentation

The API documentation is available at:
- Swagger UI: `http://localhost:8011/swagger-ui.html`
- API Gateway: `http://localhost:8011`

## 🔐 Security

- JWT-based authentication
- Role-based access control
- Secure password storage
- CORS configuration
- Rate limiting

## 🎯 Future Enhancements

- [ ] Real-time notifications
- [ ] File upload functionality
- [ ] Advanced reporting
- [ ] Mobile application
- [ ] Integration with external services

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Contributors

- Your Name - Initial work

## 🙏 Acknowledgments

- Spring Boot Team
- React Team
- All contributors and supporters
