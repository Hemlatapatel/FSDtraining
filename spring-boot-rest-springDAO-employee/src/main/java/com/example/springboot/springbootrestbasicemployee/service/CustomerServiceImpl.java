package com.example.springboot.springbootrestbasicemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.springbootrestbasicemployee.dao.CustomerRepositoryDAO;
import com.example.springboot.springbootrestbasicemployee.entity.Customer;
import com.example.springboot.springbootrestbasicemployee.rest.EmployeeNotFoundException;

public class CustomerServiceImpl implements CustomerService{

	private CustomerRepositoryDAO  customerRepositoryDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepositoryDAO customerRepositoryDAO) {
		super();
		this.customerRepositoryDAO = customerRepositoryDAO;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepositoryDAO.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer = customerRepositoryDAO.findById(id);
		if(customer == null) {
			throw new EmployeeNotFoundException("Customer not found id : " + id);
		}
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepositoryDAO.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerRepositoryDAO.deleteById(id);
	}

}
