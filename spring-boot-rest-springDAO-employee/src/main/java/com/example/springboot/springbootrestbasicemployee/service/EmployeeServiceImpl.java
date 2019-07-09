package com.example.springboot.springbootrestbasicemployee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.springbootrestbasicemployee.dao.EmployeeRepositoryDAO;
import com.example.springboot.springbootrestbasicemployee.entity.Employee;
import com.example.springboot.springbootrestbasicemployee.rest.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepositoryDAO employeeRepositoryDAO;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepositoryDAO employeeRepositoryDAO) {
		super();
		this.employeeRepositoryDAO = employeeRepositoryDAO;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepositoryDAO.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> empOptional = employeeRepositoryDAO.findById(id);
		
		if(!empOptional.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found : " + id);
		}
		return empOptional;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepositoryDAO.save(employee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		 employeeRepositoryDAO.deleteById(id);;
	}

	
}
