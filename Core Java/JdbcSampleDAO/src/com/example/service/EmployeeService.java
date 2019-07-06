package com.example.service;

import com.example.model.Employee;

public interface EmployeeService {

	public void createEmployee(Employee employee);

	public void getAllEmployees();

	public void getEmployeeByFirstName(String fName);

	public void updateById(int id);

	public void deleteById(int id);
}
