package com.example.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.ProductRepository;
import com.example.entity.ProductEntity;
import com.example.shared.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void createProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
		
		productRepository.save(productEntity);
		
	}

	@Override
	public ProductEntity getById(int id) {
		// TODO Auto-generated method stub
		
		return productRepository.findById(id).get();
	}

}
