package com.itp.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = {"department", "projects", "addresses"})
@Builder
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 10)
    private String gender;
    @Column(nullable = false, length = 100)
    private String designation;
    @Column(nullable = false)
    private LocalDate joiningDate;
    @Column(nullable = false, length = 100)
    private String reportingManager;
    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentid", nullable = false)
    private Department department;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime modifiedAt;
    @PrePersist
    protected void atCreation() {
        LocalDateTime now=LocalDateTime.now();
        this.createdAt=now;
        this.modifiedAt=now;
    }
    @PreUpdate
    protected void atUpdation() {
        this.modifiedAt=LocalDateTime.now();
    }
}
