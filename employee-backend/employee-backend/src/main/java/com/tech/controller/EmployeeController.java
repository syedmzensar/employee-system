package com.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.dto.EmployeeDto;
import com.tech.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<EmployeeDto>(this.employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		return new ResponseEntity<List<EmployeeDto>>(this.employeeService.getAllEmployees(), HttpStatus.OK);
	}

	// update
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) {
		return new ResponseEntity<EmployeeDto>(this.employeeService.updateEmployee(employeeDto, id), HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		this.employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("employee deleted successfully", HttpStatus.OK);
	}

	// get by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
		return new ResponseEntity<EmployeeDto>(this.employeeService.getEmployeeById(id), HttpStatus.ACCEPTED);
	}

}
