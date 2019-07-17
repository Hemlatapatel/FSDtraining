package com.example.myphotoappuserservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserModel {
	
	@NotNull(message = "first name can not be null")
	private String firstName;
	
	@NotNull(message = "last name can not be null")
	private String lastName;
	
	@NotNull(message = "password can not be null")
	private String password;
	
	
	@NotNull(message = "email can not be null")
	@Email
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	
	
}
