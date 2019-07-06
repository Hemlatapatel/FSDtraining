package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDAO {
	
	public void createEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public void getEmployeeByFirstName(String fName);
	

	
}
