package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {

    List<Education> findByEmployeeId(Long employeeId);
    // any custom methods can be added here
}