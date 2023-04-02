package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Employment;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

    List<Employment> findByEmployeeId(Long employeeId);

}