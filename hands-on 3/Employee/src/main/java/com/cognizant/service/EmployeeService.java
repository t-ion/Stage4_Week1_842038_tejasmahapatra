package com.cognizant.service;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.model.Employee;
import com.cognizant.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

	EmployeeDao employeeDao=new EmployeeDao();
	public ArrayList<Employee> getAllEmployee() {
		return employeeDao.getAllEmployees();
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		employeeDao.updateEmployee(employee);
	}
	public void deleteEmployee(String id) throws EmployeeNotFoundException{
		employeeDao.deleteEmployee(id);
		}

}
