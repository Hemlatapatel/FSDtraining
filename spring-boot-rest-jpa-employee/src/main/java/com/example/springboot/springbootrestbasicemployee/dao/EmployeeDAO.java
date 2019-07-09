package com.example.springboot.springbootrestbasicemployee.dao;

import java.util.List;

import com.example.springboot.springbootrestbasicemployee.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(int id);
	
	Employee saveEmployee(Employee employee);
		
	Employee deleteEmployee(int id);
}
