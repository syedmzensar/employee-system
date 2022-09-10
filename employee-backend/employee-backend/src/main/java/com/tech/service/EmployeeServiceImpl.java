package com.tech.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dto.EmployeeDto;
import com.tech.entity.Employee;
import com.tech.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = this.modelMapper.map(employeeDto, Employee.class);

		Employee savedEmployee = this.employeeRepository.save(employee);

		return this.modelMapper.map(savedEmployee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = this.employeeRepository.findAll();

		List<EmployeeDto> employeesDto = employees.stream()
				.map((employee) -> this.modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

		return employeesDto;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer id) {
		Employee employee = this.employeeRepository.findById(id).get();
		
		
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmailId(employeeDto.getEmailId());

		this.employeeRepository.save(employee);

		return this.modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Integer id) {
		this.employeeRepository.deleteById(id);

	}

	@Override
	public EmployeeDto getEmployeeById(Integer id) {
		Employee employee = this.employeeRepository.findById(id).get();
		return this.modelMapper.map(employee, EmployeeDto.class);
	}

}
