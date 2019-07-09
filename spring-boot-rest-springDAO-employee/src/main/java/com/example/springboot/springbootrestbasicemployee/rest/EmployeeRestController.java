package com.example.springboot.springbootrestbasicemployee.rest;

import java.util.List;
import java.util.Optional;

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
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);

	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {

		Employee theEmployee = service.saveEmployee(employee);
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee theEmployee = service.saveEmployee(employee);
		return theEmployee;
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		service.deleteEmployee(id);

		return "deleted successfully";
	}
}
