package com.example.service;

import com.example.entity.CustomerEntity;
import com.example.shared.CustomerDto;

public interface CustomerService {

	void createCustomer(CustomerDto  customerDto);
	
    CustomerEntity getById(int id);
}
