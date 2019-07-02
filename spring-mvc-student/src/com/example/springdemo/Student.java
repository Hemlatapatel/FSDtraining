package com.example.springdemo;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

	@NotNull(message="field can not be null")
	@Size(min=1, message="first name required")
	private String firstName;
	
	@NotNull(message="field can not be null")
	@Size(min=1, message="last name required")
	private String lastName;
	
	@NotNull(message="field can not be null")
	@Size(min=1, message="country required")
	private String country;
	
//	@NotNull(message="field can not be null")
//	@Size(min=1, message="language required")
//	private String[] language= {"Java", "Python", "Blockchain", "Ruby"};
	
	@NotNull(message="field can not be null")
	@Size(min=1, message="first name required")
	private String favoriteLanguage;
	
	@NotNull(message="field can not be null")
	@Size(min=1, message="operating system required")
	private String[] operatingSystem = {"windows", "linux", "MAC", "android"};
 	private int id;
 	private String operating;
 	
	private LinkedHashMap<String, String> countries = new LinkedHashMap<String, String>();
	public Student() {
		super();
		countries.put("BR", "Brazil");
		countries.put("FR", "France");
		countries.put("IN", "India");
		countries.put("US", "United State");
	}


	public Student(String firstName, String lastName, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}

	public String getOperating() {
		return operating;
	}


	public void setOperating(String operating) {
		this.operating = operating;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}


	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String[] getOperatingSystem() {
		return operatingSystem;
	}


	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}


	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", favoriteLanguage=" + favoriteLanguage + ", operatingSystem=" + Arrays.toString(operatingSystem)
				+ ", id=" + id + "]";
	};
	
	
	
}
