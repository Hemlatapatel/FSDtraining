package com.example.demo;

public class UserServiceImpl implements UserService {

	private UserDaoImpl dao;
	
	
	
	public UserDaoImpl getDao() {
		return dao;
	}



	public void setDao(UserDaoImpl dao) {
		this.dao = dao;
	}



	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return dao.checkUser(user);
	}

}
