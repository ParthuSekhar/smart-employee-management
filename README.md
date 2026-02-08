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

2. Configure Database
   ```code
   src/main/resources/application.properties
   ```
   
3. Update with your MySQl deatils:
   ```properties:
   spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
4. Create Database in MySql
   ```Sql
   CREATE DATABASE ems_db;
   ```

5. Run the Application
   5.1 In Eclipse, navigate to:
   ```code
   src/main/java/com/parthu/smart_employee_management
   ```
   5.2 Right click-on:
       SmartEmployeeManagementApplication.java
   5.3 Select
       Run As -> Spring Boot App

6. Verify Application
   ```code
   Tomcat started on port 8080
  Started SmartEmployeeManagementApplication

7. Access APIs
   ```URL
   https://localhost:8080
   ```
   ```Swagger Ui:
   http://localhost:8080/swagger-ui.html
   ```

8. Test APIs
   Postman
   Swagger Ui
     
