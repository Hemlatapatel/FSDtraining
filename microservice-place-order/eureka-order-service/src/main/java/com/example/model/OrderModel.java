package com.example.model;

import java.util.List;

public class OrderModel {

	private CustomerModel customer;
	private ProductModel product;
	private int amount;
	
	public CustomerModel getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
	public ProductModel getProduct() {
		return product;
	}
	
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
