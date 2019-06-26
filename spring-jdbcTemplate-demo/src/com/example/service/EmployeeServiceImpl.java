package com.example.service;

import java.util.List;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;


	public EmployeeServiceImpl(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public Employee getEmpoyeeById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmpoyeeById(id);
	}

	@Override
	public String updateEmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.updateEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployeeByName(String fName) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByName(fName);
	}

}
