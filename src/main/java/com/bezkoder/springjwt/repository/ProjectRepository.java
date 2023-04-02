package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.ProjectDetails;

public interface ProjectRepository extends JpaRepository<ProjectDetails, Long> {
    // any custom methods can be added here
}