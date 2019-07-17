package com.example.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.CustomerEntity;
import com.example.entity.ProductEntity;
import com.example.model.CustomerModel;
import com.example.model.OrderModel;
import com.example.model.ProductModel;
import com.example.service.OrderService;
import com.example.shared.OrderDto;

@RestController
@RequestMapping("/")
public class OrderRestController {

	private RestTemplate restTemplate;
	private OrderService orderService;
	
    @Autowired
    public OrderRestController(RestTemplate restTemplate, OrderService orderService) {
		super();
		this.restTemplate = restTemplate;
		this.orderService = orderService;
	}

	@RequestMapping("/")
	public String hello() {
		return "Gallery controller is running";
	}
	
	@RequestMapping("/{id}")
	public OrderDto getOrder(@PathVariable int id) {
		
		OrderDto orderDto = new OrderDto();
		
		CustomerEntity customerEntity = restTemplate.getForObject("http://customer-service/customers/"+id, 
				CustomerEntity.class);
		
		ProductEntity productEntity = restTemplate.getForObject("http://product-service/products/"+id, 
				ProductEntity.class);
		
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		CustomerModel customer = modelMapper.map(customerEntity, CustomerModel.class);
		ProductModel product = modelMapper.map(productEntity, ProductModel.class);
		
		orderDto.setCustomer(customer);
		orderDto.setProduct(product);
		orderDto.setAmount(60000);
		orderDto.setoId(UUID.randomUUID().toString());
		orderService.createOrder(orderDto);
		return orderDto;
		
	}
}

