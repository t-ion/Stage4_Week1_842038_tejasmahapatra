package com.cognizant.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Department {
	@NotNull
	@Pattern(regexp = "[0-9]+",message = "Should be a number")
	String id;
	@NotNull(message = "should not be null") @NotBlank
	@Pattern(regexp = "[a-zA-Z] {1,30}")
	String name;
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	

}