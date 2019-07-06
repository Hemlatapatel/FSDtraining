package com.example.service;

import com.example.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {

	
	private LoginDAOImpl ldimpl = null;

	public LoginServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		ldimpl = new LoginDAOImpl();
	}

	@Override
	public boolean login(String userId, String password) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		return ldimpl.login(userId, password);
	}

}
