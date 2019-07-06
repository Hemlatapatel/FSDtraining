package com.serializable.student;

import java.io.Serializable;

public class Student implements Serializable{

	private String id;
	private String name;
	private String address;
	
	// if it is not transient then implements Course class by serializable
	private transient Course course;

	public Student() {
		super();
	}

	public Student(String id, String name, String address, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.course = course;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
