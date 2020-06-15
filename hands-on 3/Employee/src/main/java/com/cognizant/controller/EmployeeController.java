package com.cognizant.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public ArrayList<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

    @PutMapping(value="update",consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable String id) throws EmployeeNotFoundException {
		employeeService.deleteEmployee(id);
	}
}