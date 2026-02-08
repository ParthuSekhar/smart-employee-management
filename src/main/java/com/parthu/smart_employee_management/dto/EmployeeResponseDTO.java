package com.parthu.smart_employee_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Double salary;
}