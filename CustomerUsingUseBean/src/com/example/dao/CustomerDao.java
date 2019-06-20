package com.example.dao;

import java.sql.ResultSet;

import com.example.model.Customer;

public interface CustomerDao {

	public boolean createCustomer(Customer customer);
	
	public ResultSet getAllCustomer();
	
	public boolean  updateById(Customer customer);
	
	public boolean deleteById(int id);
}
