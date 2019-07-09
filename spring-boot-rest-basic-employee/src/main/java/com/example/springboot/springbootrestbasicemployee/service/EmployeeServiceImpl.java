package com.example.springboot.springbootrestbasicemployee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.springbootrestbasicemployee.dao.EmployeeDAO;
import com.example.springboot.springbootrestbasicemployee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		dao.createEmployee(employee);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		dao.deleteEmployee(id);
	}

}
