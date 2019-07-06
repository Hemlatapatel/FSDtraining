package com.example.dao;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerDao {

	List<Customer> getAllCustomer();
	
	void createCustomer(Customer customer);
	
	Customer findById(int id);
	
	void update(Customer customer);
	
	void delete(int id);
}
