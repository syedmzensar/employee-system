package com.tech.service;

import java.util.List;

import com.tech.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id);

	void deleteEmployee(Integer id);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto getEmployeeById(Integer id);

}
