package com.itp.employee_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude = "employee")
@Builder
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(nullable = false, length = 100)
    private String locality;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 50)
    private String state;
    @Column(nullable = false, length = 50)
    private String country;
    @Column(nullable = false, length = 6)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeid")
    private Employee employee;

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
