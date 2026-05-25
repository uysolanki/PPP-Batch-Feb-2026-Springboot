package com.itp.employee_management_system.dto;

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
public class ProjectDTO {
    private String projectName;
    private Double budget;
    private String clientName;
    private String technologyStack;
    private Integer teamSize;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<Integer> employees = new ArrayList<>();
}
