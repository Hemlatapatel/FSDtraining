package com.example.service;

import java.sql.ResultSet;

import com.example.dao.EmployeeDAOImpl;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAOImpl edimpl = null;

	public EmployeeServiceImpl() {
		super();
		// TODO Auto-generated constructor stub

		edimpl = new EmployeeDAOImpl();
	}

	@Override
	public ResultSet getAllEmployees() {
		// TODO Auto-generated method stub
		return edimpl.getAllEmployees();
	}

	@Override
	public ResultSet findByFirstName(String fName) {
		// TODO Auto-generated method stub
		return edimpl.findByFirstName(fName);
	}

	@Override
	public ResultSet updateById(int id) {
		// TODO Auto-generated method stub
		return edimpl.updateById(id);
	}

	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return edimpl.update(employee);
	}
	
	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated methseod stub
		return edimpl.deleteById(id);
	}

	@Override
	public boolean insert(Employee employee) {
		// TODO Auto-generated method stub
		return edimpl.insert(employee);
	}

	
}
