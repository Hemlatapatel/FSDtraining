package com.example.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.ProductEntity;
import com.example.model.ProductModel;
import com.example.service.ProductService;
import com.example.shared.ProductDto;

import net.bytebuddy.agent.builder.AgentBuilder.Matchable;

@RestController
@RequestMapping("/")
public class ProductRestController {

	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("/products")
	public String createProduct(@RequestBody ProductModel productModel) {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProductDto produectDto = modelMapper.map(productModel, ProductDto.class);
        productService.createProduct(produectDto);
		return "product created successfully";

	}

	@GetMapping("/products/{id}")

	public ProductEntity getById(@PathVariable int id) {

		return productService.getById(id);
	}
}
