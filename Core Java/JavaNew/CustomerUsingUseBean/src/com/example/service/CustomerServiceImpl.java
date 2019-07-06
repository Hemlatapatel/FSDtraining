package com.example.service;

import java.sql.ResultSet;

import com.example.dao.CustomerDAOImpl;
import com.example.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAOImpl dao = null;
	public CustomerServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		dao = new CustomerDAOImpl();
	}

	@Override
	public boolean createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(customer);
	}

	@Override
	public ResultSet getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}

	@Override
	public boolean updateById(Customer customer) {
		// TODO Auto-generated method stub
		return dao.updateById(customer);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}

}
