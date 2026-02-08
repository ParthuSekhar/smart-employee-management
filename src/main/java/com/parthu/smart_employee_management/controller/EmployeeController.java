
package com.parthu.smart_employee_management.controller;
import com.parthu.smart_employee_management.dto.EmployeeRequestDTO;
import com.parthu.smart_employee_management.dto.EmployeeResponseDTO;
import com.parthu.smart_employee_management.service.EmployeeService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Employee APIs", description = "Employee Management Operations")
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController  {

    private final EmployeeService employeeService;

    // CREATE
    @PostMapping
    public EmployeeResponseDTO createEmployee(
            @Valid @RequestBody EmployeeRequestDTO dto) {
        return employeeService.createEmployee(dto);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // GET ALL (pagination)
    @GetMapping
    public Page<EmployeeResponseDTO> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.getAllEmployees(page, size, sortBy);
    }

    // UPDATE
    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
