package com.example.factory;

import java.sql.*;
import java.io.*;
import java.util.*;

public class CustomerFactory {
	public static Connection con = null;
	private static CustomerFactory customerFactory;

	private CustomerFactory() {
		try {
			getClass().forName("com.mysql.jdbc.Driver");

			FileInputStream fis = new FileInputStream("jdbc.properties");
			Properties prop = new Properties();
			prop.load(fis);

			String jdbcUrl = prop.getProperty("jdbcUrl");
			String userName = prop.getProperty("userName");
			String password = prop.getProperty("password");

			con = DriverManager.getConnection(jdbcUrl, userName, password);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static synchronized CustomerFactory getMyConnection() {
		if (customerFactory == null) {
			customerFactory = new CustomerFactory();
		} 
		return customerFactory;
	}
}
