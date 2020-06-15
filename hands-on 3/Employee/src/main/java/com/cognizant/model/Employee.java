package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
public class Employee {
	
	@NotNull
	@Pattern(regexp = "[0-9]+",message = "Should be a number")
	String id;
	@NotNull(message = "should not be null") @NotBlank
	@Pattern(regexp = "[a-zA-Z]{1,30}")
	String name;
	@NotNull(message = "should not be null")
	@Pattern(regexp = "[0-9]+",message = "Should be zero or above")
	String salary;
	@NotNull(message = "should not be null")
	String permanent;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	String dateOfBirth;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String id, String name, String salary, String permanent, String dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPermanent() {
		return permanent;
	}
	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}