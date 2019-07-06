package com.example.service;

import com.example.dao.CustomerDAOImplement;
import com.example.model.Customer;

public class CustomerServiceImplement implements CustomerService{

	private CustomerDAOImplement cdimpl = null;
	
	public CustomerServiceImplement() {
		super();
		cdimpl = new CustomerDAOImplement();
	}
	@Override
	public void createCustomer() {
		// TODO Auto-generated method stub
		cdimpl.createCustomer();
		
	}
	
	public void writeObjectToFile() {
		cdimpl.writeObjectToFile();
	}

}
