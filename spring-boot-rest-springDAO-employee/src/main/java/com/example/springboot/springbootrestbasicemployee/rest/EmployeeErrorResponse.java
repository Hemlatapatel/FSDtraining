package com.example.springboot.springbootrestbasicemployee.rest;

public class EmployeeErrorResponse {

	private int status;
	private String message;
	private double timeOccured;
	public EmployeeErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeErrorResponse(int status, String message, double timeOccured) {
		super();
		this.status = status;
		this.message = message;
		this.timeOccured = timeOccured;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getTimeOccured() {
		return timeOccured;
	}
	public void setTimeOccured(double timeOccured) {
		this.timeOccured = timeOccured;
	}
	
	
}
