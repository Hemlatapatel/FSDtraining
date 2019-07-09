package com.example.springboot.springbootrestbasicemployee.service;

import java.util.List;
import java.util.Optional;

import com.example.springboot.springbootrestbasicemployee.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Optional<Employee> getEmployeeById(int id);

	Employee saveEmployee(Employee employee);


	void deleteEmployee(int id);

}
