package comm.example.springdemo.service;

import java.util.List;

import comm.example.springdemo.entity.Customer;

public interface CustomerService {

List<Customer> getAllCustomer();
	
	void createCustomer(Customer customer);
	
	Customer getCustomer(int id);
	
	void update(Customer customer);
	
	boolean deleteCustomer(int id);
}
