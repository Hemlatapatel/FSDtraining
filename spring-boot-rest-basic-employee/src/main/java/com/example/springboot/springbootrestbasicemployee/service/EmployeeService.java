package com.example.springboot.springbootrestbasicemployee.service;

import java.util.List;

import com.example.springboot.springbootrestbasicemployee.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	void createEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);

}
