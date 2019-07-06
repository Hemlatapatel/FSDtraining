package com.example.factory;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Factory {

	public  Connection con=null;
	private static Factory factory;
	public Factory() {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			getClass().forName("com.mysql.jdbc.Driver");
			
			FileInputStream fis = new FileInputStream("jdbc.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String jdbcUrl = prop.getProperty("jdbcUrl");
			String userName = prop.getProperty("userName");
			String password = prop.getProperty("password");
			
			con  = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public static Factory getMyConnection() {
		if(factory ==null) {
			factory = new Factory();
		}
		return factory;
	}
	
	
	
}