package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal currentSalary;
    private String designation;
    private LocalDate dateOfJoining;

    @Lob
    private byte[] joiningLetter;

    @Lob
    private byte[] image;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // @OneToOne(mappedBy = "employeeDetails", fetch = FetchType.LAZY, cascade =
    // CascadeType.ALL, orphanRemoval = true)

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectDetail_id")
    private ProjectDetails projectDetails;

    // constructors, getters and setters, and other methods omitted for brevity
}
