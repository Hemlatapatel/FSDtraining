package com.example.model;

public class Employee {

	private int emp_id;
	private String firstName;
	private String lastName;
	private int salary;
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Employee id: ").append(getEmp_id());
		sb.append(" First name: ").append(getFirstName());
		sb.append(" last name: ").append(getLastName());
		sb.append(" Salary: ").append(getSalary());
		
		return sb.toString();
//		return "Employee [emp_id=" + emp_id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
//				+ salary + "]";
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Employee(int emp_id, String firstName, String lastName, int salary) {
		super();
		this.emp_id = emp_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
}
