package com.bezkoder.springjwt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Employment;
import com.bezkoder.springjwt.repository.EmploymentRepository;

@RestController
@RequestMapping("/employment")
public class EmploymentController {

    @Autowired
    private EmploymentRepository employmentRepository;

    @PostMapping
    public Employment createEmployment(@RequestBody Employment employment) {
        return employmentRepository.save(employment);
    }

    @GetMapping("/{id}")
    public Employment getEmploymentById(@PathVariable Long id) {
        return employmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employment", "id", id));
    }

    @GetMapping("/employee/{employeeId}")
    public List<Employment> getEmploymentByEmployeeId(@PathVariable Long employeeId) {
        return employmentRepository.findByEmployeeId(employeeId);
    }

    @PutMapping("/employments/{id}")
    public ResponseEntity<Employment> updateEmployment(@PathVariable(value = "id") Long employmentId,
            @Valid @RequestBody Employment employmentDetails) {
        Employment employment = employmentRepository.findById(employmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Employment", "id", employmentId));

        employment.setEmployer(employmentDetails.getEmployer());
        // employment.set(employmentDetails.getJobTitle());
        employment.setStartDate(employmentDetails.getStartDate());
        employment.setEndDate(employmentDetails.getEndDate());

        final Employment updatedEmployment = employmentRepository.save(employment);
        return ResponseEntity.ok(updatedEmployment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployment(@PathVariable Long id) {
        Employment employment = employmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employment", "id", id));

        employmentRepository.delete(employment);

        return ResponseEntity.ok().build();
    }
}