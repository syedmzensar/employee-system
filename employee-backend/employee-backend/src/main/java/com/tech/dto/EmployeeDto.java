package com.tech.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String emailId;

}
