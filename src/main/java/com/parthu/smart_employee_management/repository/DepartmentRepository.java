package com.parthu.smart_employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parthu.smart_employee_management.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}