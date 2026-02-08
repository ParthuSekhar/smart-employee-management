package com.parthu.smart_employee_management.service;

import com.parthu.smart_employee_management.dto.EmployeeRequestDTO;
import com.parthu.smart_employee_management.dto.EmployeeResponseDTO;
import com.parthu.smart_employee_management.entity.Employee;
import com.parthu.smart_employee_management.exception.ResourceNotFoundException;
import com.parthu.smart_employee_management.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());

        Employee saved = employeeRepository.save(employee);
        return mapToResponse(saved);
    }

    // GET BY ID
    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + id));

        return mapToResponse(employee);
    }

    // GET ALL (PAGINATION + SORTING)
    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees.map(this::mapToResponse);
    }

    // UPDATE
    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + id));

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());

        Employee updated = employeeRepository.save(employee);
        return mapToResponse(updated);
    }

    // DELETE
    @Override
    public void deleteEmployee(Long id) {

        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id " + id);
        }

        employeeRepository.deleteById(id);
    }

    // ENTITY → DTO MAPPER
    private EmployeeResponseDTO mapToResponse(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());

        return dto;
    }
}
