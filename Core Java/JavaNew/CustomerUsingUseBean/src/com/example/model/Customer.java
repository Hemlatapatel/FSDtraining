package com.example.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private String name;
	private String address;
	private String item;
	
	private int id;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String address, String item) {
		super();
		this.name = name;
		this.address = address;
		this.item = item;
	}
	
	
	
	public Customer(int id, String name, String address, String item) {
		super();
		this.name = name;
		this.address = address;
		this.item = item;
		this.id = id;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
}
