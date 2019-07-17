package com.example.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CustomerEntity;
import com.example.model.CustomerModel;
import com.example.service.CustomerService;
import com.example.shared.CustomerDto;

@RestController
@RequestMapping("/")
public class CustomerRestController {

	private CustomerService customerService;

	public CustomerRestController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/customers")
	public String createCustomer(@RequestBody CustomerModel customerModel) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		CustomerDto customerDto = modelMapper.map(customerModel, CustomerDto.class);
		
		customerDto.setcId(UUID.randomUUID().toString());
		customerService.createCustomer(customerDto);
		
		return "customer created successfully";
	}
	
	@GetMapping("/customers/{id}")
	
	public CustomerEntity getById(@PathVariable int id) {
		
		return customerService.getById(id);
		
	}
}
