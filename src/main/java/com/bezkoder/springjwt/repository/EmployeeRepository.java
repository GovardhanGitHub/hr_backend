package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // any custom methods can be added here
}