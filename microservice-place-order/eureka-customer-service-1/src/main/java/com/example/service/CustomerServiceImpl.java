package com.example.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.CSSUnknownRule;

import com.example.data.CustomerRepository;
import com.example.entity.CustomerEntity;
import com.example.shared.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}



	@Override
	public void createCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
		
		customerRepository.save(customerEntity);
	}



	@Override
	public CustomerEntity getById(int id) {
		// TODO Auto-generated method stub
		/*ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Optional<CustomerEntity> customerEntity = customerRepository.findById(id);*/
		
		//System.out.println("entity" + customer.get);
		//CustomerDto customerDto = modelMapper.map(customerEntity, CustomerDto.class);
		
		return customerRepository.findById(id).get();
	}

}
