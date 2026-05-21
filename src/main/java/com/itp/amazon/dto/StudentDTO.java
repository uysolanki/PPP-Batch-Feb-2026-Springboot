package com.itp.amazon.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Builder
public class StudentDTO {
	
	@NotBlank
    @Size(min = 5, max = 100,message = "Student name must be between 5 and 100 characters")
    private String sname;

    @NotBlank
    @Size(min = 5, max = 100,message = "Department name must be between 5 and 100 characters")
    private String dname;

    @DecimalMin(value = "40.0", message = "Percentage must be greater than or equal to 40")
    @DecimalMax(value = "100.0",message = "Percentage must be less than or equal to 100")
    private double per;
}
