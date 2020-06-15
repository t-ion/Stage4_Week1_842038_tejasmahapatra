package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cognizant.dao.DepartmentDao;
import com.cognizant.model.Department;
@Service
public class DepartmentService {
DepartmentDao deptdao=new DepartmentDao();
	
	public ArrayList<Department> getAllDepartments(){
		return deptdao.getAllDepartments();
	}

}
