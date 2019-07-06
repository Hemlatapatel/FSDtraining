package com.example.model;

public class Login {

	private String UserId;
	private String password;
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String userId, String password) {
		super();
		UserId = userId;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [UserId=" + UserId + ", password=" + password + "]";
	}
}
