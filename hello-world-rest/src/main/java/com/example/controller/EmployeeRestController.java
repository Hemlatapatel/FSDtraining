package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDaoImpl;
import com.example.entity.Address;
import com.example.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	EmployeeDaoImpl dao;

	private List<Employee> employees = null;

	@PostConstruct
	public void initEmployee() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("Sachin", "Tendulkar", 10000, new Address("Mumbai", "India")));
		employees.add(new Employee("MS", "Dhoni", 400000, new Address("Pune", "India")));
		employees.add(new Employee("Rahul", "Dravid", 30000, new Address("Hyderabad", "UK")));

	}

	@GetMapping("/employees")
	public List<Employee> getEmployee() {
//		return employees;
		return dao.getEmployees();
	}

	@GetMapping("/employee/{theEmployee}")
	public Employee getEmployeeByIndex(@PathVariable int theEmployee) {

		/*
		 * if ((theEmployee >= employees.size()) || theEmployee < 0) { throw new
		 * EmployeeNotFoundException("No such employee found with id : " + theEmployee);
		 * } return employees.get(theEmployee);
		 */

		Employee emp = dao.getetEmployeeById(theEmployee);
		if (emp == null) {
			throw new EmployeeNotFoundException("No such employee found with id : " + theEmployee);
		}
		return emp;
	}

	@ExceptionHandler
	public ResponseEntity<EmployeeError> handleException(EmployeeNotFoundException exc) {
		EmployeeError error = new EmployeeError();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeOccured(System.currentTimeMillis());
		return new ResponseEntity<EmployeeError>(error, HttpStatus.NOT_FOUND);
	}
}
