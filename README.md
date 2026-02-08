# Smart Employee Management System

A Spring Boot REST API for managing employees with CRUD operations, pagination, validation, and exception handling.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Maven

## Features
- Create, update, delete employees
- Pagination & sorting
- DTO-based request/response
- Global exception handling
- MySQL integration

## Project Structure
```text
src/main/java/com/parthu/smart_employee_management
├── config
│   └── SecurityConfig.java
├── controller
│   └── EmployeeController.java
├── dto
│   ├── EmployeeRequestDTO.java
│   └── EmployeeResponseDTO.java
├── entity
│   ├── Department.java
│   ├── Employee.java
│   └── User.java
├── exception
│   ├── DuplicateResourceException.java
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── repository
│   ├── DepartmentRepository.java
│   ├── EmployeeRepository.java
│   └── UserRepository.java
├── service
│   ├── EmployeeService.java
│   └── EmployeeServiceImpl.java
└── SmartEmployeeManagementApplication.java

8 directories, 16 files
```
---

##  API Endpoints

### Employee APIs
| Method | Endpoint | Description |
|------|---------|------------|
| POST | /employees | Create employee |
| GET | /employees | Get all employees (pagination) |
| GET | /employees/{id} | Get employee by ID |
| PUT | /employees/{id} | Update employee |
| DELETE | /employees/{id} | Delete employee |

---

##  Sample Request (Create Employee)
```json
{
  "name": "Rahul",
  "email": "rahul@gmail.com",
  "salary": 50000
}
```
---

## Sample Response

```json
{
  "id": 1,
  "name": "Rahul",
  "email": "rahul@gmail.com",
  "salary": 50000
}
```
---

## API Endpoints

| Method | Endpoint              | Description              |
|------|----------------------|--------------------------|
| POST | /employees            | Create employee          |
| GET  | /employees/{id}       | Get employee by ID       |
| GET  | /employees            | Get all employees        |
| PUT  | /employees/{id}       | Update employee          |
| DELETE | /employees/{id}     | Delete employee          |

---

## Validation & Error Handling

- Email must be unique
- Request body validation using `@Valid`
- Centralized exception handling using `@RestControllerAdvice`
- Custom exceptions:
  - ResourceNotFoundException
  - DuplicateResourceException

 ## How to Run the Project

1. Clone the repository
```bash
git clone https://github.com/ParthuSekhar/smart-employee-management.git
```
2. Create database in MySQl
```SQL
CREATE DATABASE ems_db;
```
3. Configure Databse
```Update src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
4. Run the Application

Option 1 : using Maven wrapper
```bash
./mvnw spring-boot:run
```
Option 2 : using Maven
```bash
mvn spring-boot:run
```
5. Verify Application
```code
http://localhost:8080
```
6. Test APIs
```Postman
POST http://localhost:8080/employees
```






