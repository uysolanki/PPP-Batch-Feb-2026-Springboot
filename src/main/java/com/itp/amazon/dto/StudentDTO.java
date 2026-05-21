package com.itp.amazon.dto;

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
	
	private String sname;
	private String dname;
	private double per;
}
