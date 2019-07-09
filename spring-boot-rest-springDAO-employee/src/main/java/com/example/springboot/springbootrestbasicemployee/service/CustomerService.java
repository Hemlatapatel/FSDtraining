package com.example.springboot.springbootrestbasicemployee.service;

import java.util.List;
import java.util.Optional;

import com.example.springboot.springbootrestbasicemployee.entity.Customer;


public interface CustomerService {

	List<Customer> getAllCustomer();

	Optional<Customer> getCustomerById(int id);

	Customer saveCustomer(Customer customer);


	void deleteCustomer(int id);

}
