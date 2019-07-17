package com.example.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.OrderRepository;
import com.example.entity.OrderEntity;
import com.example.shared.OrderDto;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public void createOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper  = new ModelMapper();
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		OrderEntity orderEntity = new OrderEntity();
		//		= modelMapper.map(orderDto, OrderEntity.class);
		
		
		orderEntity.setCustomerName(orderDto.getCustomer().getName());
		orderEntity.setEmail(orderDto.getCustomer().getEmail());
		orderEntity.setProductName(orderDto.getProduct().getName());
		orderEntity.setDescription(orderDto.getProduct().getDescription());
		orderEntity.setAmount(orderDto.getAmount());
		orderEntity.setoId(orderDto.getoId());
		orderRepository.save(orderEntity);
				
	}

}
