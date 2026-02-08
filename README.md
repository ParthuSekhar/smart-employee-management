# Smart Employee Management System

A Spring Boot REST API for managing employees with CRUD operations, pagination, validation, and exception handling.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JSON web Token)
- MySQL
- Maven

## Features
- Create, update, delete employees
- Secure authentication using JWT
- Pagination & sorting
- DTO-based request/response
- Global exception handling
- MySQL integration
- Clean layered architeture(Controller-Service-Repository)

## Project Structure
```text
src/main/java/com/parthu/smart_employee_management
├── config
│   ├── JwtFilter.java
│   ├── PasswordConfig.java
│   └── SecurityConfig.java
├── controller
│   ├── AuthController.java
│   └── EmployeeController.java
├── dto
│   ├── AuthRequestDTO.java
│   ├── AuthResponseDTO.java
│   ├── EmployeeRequestDTO.java
│   └── EmployeeResponseDTO.java
├── entity
│   ├── Department.java
│   ├── Employee.java
│   └── User.java
├── exception
│   ├── DuplicateResourceException.java
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── repository
│   ├── DepartmentRepository.java
│   ├── EmployeeRepository.java
│   └── UserRepository.java
├── security
│   └── JwtUtil.java
├── service
│   ├── EmployeeService.java
│   └── EmployeeServiceImpl.java
└── SmartEmployeeManagementApplication.java
```
---

##  API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|------|---------|------------|
| POST | /auth/login | Login & generate JWT Token |

---

## Sample Login Request
```json
{
  "username": "admin",
  "password": "admin123"
}
```
---
## Sample Login Response
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```
---

### Employee APIs

| Method | Endpoint              | Description              |
|------|----------------------|--------------------------|
| POST | /employees            | Create employee          |
| GET  | /employees/{id}       | Get employee by ID       |
| GET  | /employees            | Get all employees        |
| PUT  | /employees/{id}       | Update employee          |
| DELETE | /employees/{id}     | Delete employee          |

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

## Pagination & Sorting
```code
GET /employees?page=0&size=5&sortBy=name
```
---

## Validation & Error Handling

- Email must be unique
- Request body validation using `@Valid`
- Centralized exception handling using `@RestControllerAdvice`
- Custom exceptions:
  - ResourceNotFoundException
  - DuplicateResourceException

Sample Erroe Response
```json
{
  "message": "Employee not found with id 10"
}
```
---

 ## How to Run the Project

 Prerequisites
 -> Java 21
 -> Eclipse IDE
 -> MySQl 
 -> Maven (bundled with Eclipse)
 
 1. Import Project into Eclipse
    
    1.1 Open Eclipse
    
    1.2 Go to File -> Import
    
    1.3 Select Existing Maven Project
    
    1.4 Click next
    
    1,5 Choose the Folder(e.g: smart-employee-management)
    
    1.6 Click Finish
    

3. Configure Database
   ```code
   src/main/resources/application.properties
   ```
   
4. Update with your MySQl deatils:
   ```properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
   spring.datasource.username=username
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
5. Create Database in MySql
   ```Sql
   CREATE DATABASE ems_db;
   ```

6. Run the Application

   5.1 In Eclipse, navigate to:
   ```code
   src/main/java/com/parthu/smart_employee_management
   ```
   
   5.2 Right click-on:
       SmartEmployeeManagementApplication.java
   
   5.3 Select
       Run As -> Spring Boot App

8. Verify Application
   ```code
   Tomcat started on port 8080
  
7. Access APIs
   
   URL:
   ```
   https://localhost:8080
   ```

   Swagger Ui:
   ```
   http://localhost:8080/swagger-ui.html
   ```

9. Test APIs

   Postman, 
   Swagger Ui

## Architecture

Controller Layer - RESt endpoints

Service Layer - Business logic

Repository Layer - Database access using JPA

DTO Pattern - Clean API contracts

Security Layer - JWT based authentication 

     
