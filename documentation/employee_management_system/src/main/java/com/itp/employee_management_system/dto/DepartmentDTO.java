package com.itp.employee_management_system.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class DepartmentDTO {
    @NotBlank(message = "Department name is required")
//    @Size(min = 2, max = 100, message = "Department name must be between 2 and 100 characters")
    private String departmentName;
    @NotBlank(message = "Department code is required")
    @Pattern(regexp = "^[A-Z]{2,5}-[0-9]{2,5}$", message = "Department code must follow format like IT-001 or HR-001")
    private String departmentCode;
    @Size(max = 250, message = "Description cannot exceed 250 characters")
    private String description;
    @NotBlank(message = "Department type is required")
    @Pattern(regexp = "^(Technical|Non-Technical)$", message = "Department type must be Technical or Non-Technical")
    private String departmentType;
    @NotNull(message = "Budget is required")
    @Positive(message = "Budget must be a positive value")
    @DecimalMin(value = "1000.00", message = "Budget must be at least 1000")
    private Double budget;
    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "Status must be ACTIVE or INACTIVE")
    private String status;

    @Valid
    private List<EmployeeDTO> employees = new ArrayList<>();
}
