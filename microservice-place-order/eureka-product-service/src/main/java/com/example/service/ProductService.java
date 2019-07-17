package com.example.service;

import com.example.entity.ProductEntity;
import com.example.shared.ProductDto;

public interface ProductService {

	void createProduct(ProductDto produectDto);
	
	ProductEntity getById(int id);
}
