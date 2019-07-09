package com.example.springboot.springbootrestbasicemployee.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.springbootrestbasicemployee.entity.Customer;
import com.example.springboot.springbootrestbasicemployee.entity.Employee;
import com.example.springboot.springbootrestbasicemployee.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {

		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);

	}

	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {

		Customer theCustomer = customerService.saveCustomer(customer);
		return theCustomer;
	}

	@PutMapping("/customers")
	public Customer updatecustomer(@RequestBody Customer customer) {
		Customer theCustomer = customerService.saveCustomer(customer);
		return theCustomer;
	}

	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);

		return "deleted successfully";
	}
}
