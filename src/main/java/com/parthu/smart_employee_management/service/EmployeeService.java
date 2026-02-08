package com.parthu.smart_employee_management.service;

import org.springframework.data.domain.Page;

import com.parthu.smart_employee_management.dto.EmployeeRequestDTO;
import com.parthu.smart_employee_management.dto.EmployeeResponseDTO;
import com.parthu.smart_employee_management.entity.Employee;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);

    EmployeeResponseDTO getEmployeeById(Long id);

    Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);

    void deleteEmployee(Long id);
}
