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
