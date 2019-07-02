package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public Employee getetEmployeeById(int id);
}
