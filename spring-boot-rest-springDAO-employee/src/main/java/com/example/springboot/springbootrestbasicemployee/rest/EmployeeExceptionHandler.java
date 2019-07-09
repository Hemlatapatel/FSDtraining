package com.example.springboot.springbootrestbasicemployee.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException (EmployeeNotFoundException e) {
		EmployeeErrorResponse res = new EmployeeErrorResponse();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage(e.getMessage());
		res.setTimeOccured(System.currentTimeMillis());
		return new ResponseEntity<EmployeeErrorResponse>(res, HttpStatus.NOT_FOUND);
	}
}
