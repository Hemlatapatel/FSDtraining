package com.example.model;

public class Customer {

	private int id;
	private String name;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Customer(int id, String name, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("Id:").append(id);
		sb.append("Name:").append(name);
		sb.append("Amount:").append(amount);
		return sb.toString();
	}
}
