package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

    List<Certification> findByEmployeeId(Long employeeId);
    // any custom methods can be added here
}