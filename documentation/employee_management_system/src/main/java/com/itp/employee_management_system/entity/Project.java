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
@ToString(exclude = "employees")
@Builder
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    private String projectName;
    private Double budget;
    private String clientName;
    private String technologyStack;
    private Integer teamSize;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "projectemployeemapping",
            joinColumns = @JoinColumn(name = "projectid"),
            inverseJoinColumns = @JoinColumn(name = "employeeid"))
    private List<Employee> employees = new ArrayList<>();

    private LocalDateTime createdAt;
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
