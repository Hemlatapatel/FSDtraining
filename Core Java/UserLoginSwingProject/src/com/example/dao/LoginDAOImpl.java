package com.example.dao;

import java.sql.*;

import com.example.factory.Factory;

public class LoginDAOImpl implements LoginDAO {

	private Connection con;
	private Factory factory;

	public LoginDAOImpl() {
		super();
		// TODO Auto-generated constructor stub

		factory = factory.getMyConnection();
		con = factory.con;
	}

	@Override
	public boolean login(String userId, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {

			PreparedStatement ps = con.prepareStatement("select * from userlogin where user_id=? and password=?");
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			System.out.println(rs);
			
			if(rs.isBeforeFirst()) {
				result = true;
			}
			else {
				result =  false;
			}
		

		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
	}
}
