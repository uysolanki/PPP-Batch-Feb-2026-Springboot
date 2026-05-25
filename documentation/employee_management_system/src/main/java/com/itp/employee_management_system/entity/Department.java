package com.itp.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "employees")
@Builder
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column(nullable = false, length = 100)
    private String departmentName;
    @Column(nullable = false, unique = true, length = 10)
    private String departmentCode;
    @Column(length = 250)
    private String description;
    @Column(nullable = false, length = 20)
    private String departmentType;
    @Column(nullable = false)
    private Double budget;
    @Column(nullable = false, length = 10)
    private String status;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();

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

    public int getEmployeeCount(){
        return employees.size();
    }
}
