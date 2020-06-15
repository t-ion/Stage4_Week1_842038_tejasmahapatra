package com.cognizant.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Employee Not Found")
public class EmployeeNotFoundException extends RuntimeException{

}
