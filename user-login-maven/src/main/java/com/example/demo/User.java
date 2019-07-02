package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull(message="field can not be null")
	@Size(min=1, message="username required")
	private String userName;
	
	@NotNull(message="field can not be null")
	@Size(min=1, message="password required")
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
