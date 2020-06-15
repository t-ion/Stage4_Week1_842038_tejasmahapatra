package com.cognizant.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.model.Employee;
import com.cognizant.service.exception.EmployeeNotFoundException;

public class EmployeeDao {
	public static ArrayList<Employee> emplist;

	@SuppressWarnings("unchecked")
	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		emplist = context.getBean("empList", ArrayList.class);
		((AbstractApplicationContext) context).close();
	}

	public ArrayList<Employee> getAllEmployees() {
		return emplist;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {

		for (Employee emp : emplist) {
			if (emp.getId().equals(employee.getId())) {
				emplist.remove(emp);
				emplist.add(employee);
				return;
			}
		}
		throw new EmployeeNotFoundException();
	}

	public void deleteEmployee(String id) throws EmployeeNotFoundException {
		for (Employee emp : emplist) {
			if (emp.getId().equals(id)) {
				emplist.remove(emp);
				return;
			}
		}
		throw new EmployeeNotFoundException();
	}
}
