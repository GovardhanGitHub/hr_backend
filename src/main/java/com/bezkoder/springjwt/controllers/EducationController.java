package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Education;
import com.bezkoder.springjwt.repository.EducationRepository;

@CrossOrigin(allowCredentials = "true", origins = "http://210.18.189.94:8084", allowedHeaders = "*")
@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @PostMapping
    public Education createEducation(@RequestBody Education education) {
        return educationRepository.save(education);
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable Long id) {
        return educationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));
    }

    @GetMapping("/employee/{employeeId}")
    public List<Education> getEducationByEmployeeId(@PathVariable Long employeeId) {
        return educationRepository.findByEmployeeId(employeeId);
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable Long id, @RequestBody Education educationRequest) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));

        education.setDegree(educationRequest.getDegree());
        // education.setMajor(educationRequest.getMajor());
        // education.setUniversity(educationRequest.getUniversity());
        // education.setYear(educationRequest.getYear());

        return educationRepository.save(education);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));

        educationRepository.delete(education);

        return ResponseEntity.ok().build();
    }
}