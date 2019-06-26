package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();
	
	public Employee getEmpoyeeById(int id);
	
	public String updateEmployeeById(int id);
	
	public List<Employee> getEmployeeByName(String fName);
}
