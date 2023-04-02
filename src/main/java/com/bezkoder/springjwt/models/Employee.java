
package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
    // FetchType.LAZY, mappedBy = "employee")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id")
    private List<Education> educationList = new ArrayList<>();

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
    // FetchType.LAZY, mappedBy = "employee")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "certification_id")
    private List<Certification> certificationList = new ArrayList<>();

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch =
    // FetchType.LAZY, mappedBy = "employee")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_id")
    private List<Employment> employmentList = new ArrayList<>();

    // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval =
    // true, mappedBy = "employee")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeDetail_id")
    private EmployeeDetails employeeDetails;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "authentication_id")
    // private Authentication authentication;

    // constructors, getters and setters, and other methods omitted for brevity
}
