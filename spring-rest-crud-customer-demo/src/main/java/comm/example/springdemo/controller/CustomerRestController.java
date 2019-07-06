package comm.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import comm.example.springdemo.entity.Customer;
import comm.example.springdemo.response.CustomerNotFoundException;
import comm.example.springdemo.response.CustomerResponse;
import comm.example.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	CustomerResponse response = new CustomerResponse();

	
	@Autowired
	private CustomerService service;

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = service.getCustomer(id);
		if (customer == null) {

			throw new CustomerNotFoundException("No such Customer found with id : " + id);

		}
		return customer;
	}

	@PostMapping("/customers")
	public CustomerResponse createCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		service.createCustomer(customer);
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Customer added successfully");
		response.setTimeOccured(System.currentTimeMillis());
		return response;
	}
	
	@PutMapping("/customers")
	public CustomerResponse updateCustomer(@RequestBody Customer customer) {
		service.createCustomer(customer);
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Customer updated successfully");
		response.setTimeOccured(System.currentTimeMillis());
		return response;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		if(!service.deleteCustomer(id)) {
			throw new CustomerNotFoundException("No such customer found with id: " + id);
			
		}
		return "Customer deleted successfully";
	}
	
}
