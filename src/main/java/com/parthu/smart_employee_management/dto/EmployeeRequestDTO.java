package com.parthu.smart_employee_management.dto;
import jakarta.validation.constraints.*;

public class EmployeeRequestDTO {

	@NotBlank
    private String name;
	@Email
	@NotBlank
    private String email;
	@NotNull
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
