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

import com.bezkoder.springjwt.models.Certification;
import com.bezkoder.springjwt.repository.CertificationRepository;

@CrossOrigin(allowCredentials = "true", origins = "http://210.18.189.94:8084", allowedHeaders = "*")
@RestController
@RequestMapping("/certification")
public class CertificationController {

    @Autowired
    private CertificationRepository certificationRepository;

    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationRepository.save(certification);
    }

    @GetMapping("/{id}")
    public Certification getCertificationById(@PathVariable Long id) {
        return certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification", "id", id));
    }

    @GetMapping("/employee/{employeeId}")
    public List<Certification> getCertificationsByEmployeeId(@PathVariable Long employeeId) {
        return certificationRepository.findByEmployeeId(employeeId);
    }

    @PutMapping("/{id}")
    public Certification updateCertification(@PathVariable Long id, @RequestBody Certification certificationRequest) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification", "id", id));

        certification.setCertificationName(certificationRequest.getCertificationName());
        certification.setCertificationAuthority(certificationRequest.getCertificationAuthority());
        certification.setDateEarned(certificationRequest.getDateEarned());
        certification.setCertificationNumber(certificationRequest.getCertificationNumber());

        return certificationRepository.save(certification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCertification(@PathVariable Long id) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification", "id", id));

        certificationRepository.delete(certification);

        return ResponseEntity.ok().build();
    }
}
