package com.cognizant.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Department;
import com.cognizant.service.DepartmentService;


@RestController
public class DepartmentController {

	@Autowired
	DepartmentService service;
	
	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments(){
		return service.getAllDepartments();
	}
}