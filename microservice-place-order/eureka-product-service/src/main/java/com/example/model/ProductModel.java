package com.example.model;

import javax.validation.constraints.NotNull;

public class ProductModel {

	@NotNull(message="Name can not be null")
	private String name;
	
	@NotNull(message="Name can not be null")
    private String description;
	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}
