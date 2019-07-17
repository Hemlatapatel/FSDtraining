package com.example.shared;

import java.io.Serializable;
import java.util.List;

import com.example.model.CustomerModel;
import com.example.model.ProductModel;

public class OrderDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681693867931538393L;

	private CustomerModel customer;
	private ProductModel product;
	private int amount;
	private String oId;
	
	
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
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
}
