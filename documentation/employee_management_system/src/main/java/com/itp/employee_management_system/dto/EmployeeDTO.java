package com.itp.employee_management_system.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class EmployeeDTO {
    @NotBlank(message = "Employee name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other")
    private String gender;
    @NotBlank(message = "Designation is required")
    @Size(min = 2, max = 100, message = "Designation must be between 2 and 100 characters")
    private String designation;
    @NotNull(message = "Joining date is required")
    @PastOrPresent(message = "Joining date cannot be a future date")
    private LocalDate joiningDate;
    @Size(max = 100, message = "Reporting manager name cannot exceed 100 characters")
    private String reportingManager;
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be a positive value")
    @DecimalMin(value = "10000.00", message = "Salary must be at least 10000")
    @DecimalMax(value = "10000000.00", message = "Salary cannot exceed 10000000")
    private Double salary;
    private Boolean active=true;

    @Valid
    private List<AddressDTO> addresses = new ArrayList<>();
}
