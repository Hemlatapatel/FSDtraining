package com.example.service;

import java.util.*;

import com.example.dao.EmployeeDAOImplement;
import com.example.model.Employee;

public class EmployeeServiceImplement implements EmployeeService {

	private EmployeeDAOImplement edimpl = null;
	private List<Employee> list = null;

	public EmployeeServiceImplement() {
		super();

		edimpl = new EmployeeDAOImplement();
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub

		edimpl.createEmployee(employee);
	}

	@Override
	public void getAllEmployees() {
		// TODO Auto-generated method stub
		list = new ArrayList<Employee>();
		List<Employee> list = edimpl.getAllEmployee();
		for (Employee e : list) {
			System.out.println(e);
		}
	}

	public void getEmployeeByFirstName(String fName) {

		edimpl.getEmployeeByFirstName(fName);

	}

	public void getEmployeeById(int id) {

		edimpl.getEmployeeById(id);

	}

	public void updateById(int id) {
		edimpl.updateById(id);
	}

	public void deleteById(int id) {
		edimpl.deleteById(id);
	}
}
