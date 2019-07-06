package com.example.model;

public class Organisation {

	private String name;
	private int numberOfEmployee;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	public Organisation(String name, int numberOfEmployee) {
		super();
		this.name = name;
		this.numberOfEmployee = numberOfEmployee;
	}
	@Override
	public String toString() {
		return "Organisation [name=" + name + ", numberOfEmployee=" + numberOfEmployee + "]";
	}
	
	
}
