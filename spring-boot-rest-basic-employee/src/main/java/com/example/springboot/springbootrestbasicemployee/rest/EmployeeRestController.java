package com.example.springboot.springbootrestbasicemployee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.springbootrestbasicemployee.entity.Employee;
import com.example.springboot.springbootrestbasicemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService service;

	@Autowired
	public EmployeeRestController(EmployeeService service) {
		super();
		this.service = service;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee employee = service.getEmployeeById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not found of id : " + id);
		}
		return employee;
	}

	@PostMapping("/employees")
	public String createEmployee(@RequestBody Employee employee) {
		
		service.createEmployee(employee);
		return "Employee created successfully";
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		service.createEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);
		return "Employee deleted successfully";
	}
}
