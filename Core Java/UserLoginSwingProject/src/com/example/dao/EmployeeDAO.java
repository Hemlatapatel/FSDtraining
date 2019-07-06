package com.example.dao;

import java.sql.ResultSet;

import com.example.model.Employee;

public interface EmployeeDAO {

	public ResultSet getAllEmployees();
	
	public ResultSet findByFirstName(String fName);
	
	public ResultSet updateById(int id);
	
	public boolean update(Employee employee);
	
	public boolean deleteById(int id);
	
	public boolean insert(Employee employee);
}
