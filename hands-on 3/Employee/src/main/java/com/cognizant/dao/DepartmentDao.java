package com.cognizant.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.model.Department;

public class DepartmentDao {
public static ArrayList<Department>DEPARTMENT_LIST;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Department>getAllDepartments() {
		ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST=context.getBean("deptList",ArrayList.class);
		((AbstractApplicationContext) context).close();
		return DEPARTMENT_LIST;
	}
}
