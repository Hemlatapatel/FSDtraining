package com.example.service;

import java.sql.ResultSet;

import com.example.dao.EmployeeDAOImpl;
import com.example.model.Employee;

public interface EmployeeService {
	
	public ResultSet getAllEmployees();
	public ResultSet findByFirstName(String fName);
	
	public ResultSet updateById(int id);
	
	public boolean update(Employee employee);
	
	public boolean deleteById(int id);
	
	public boolean insert(Employee employee);
}
