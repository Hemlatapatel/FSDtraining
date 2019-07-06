package com.example.app;

import com.example.model.Customer;
import com.example.service.CustomerServiceImplement;

public class MyJdbcApp {
	public static void main(String args[]) {
		CustomerServiceImplement service = new CustomerServiceImplement();
		service.createCustomer();
		
		service.writeObjectToFile();
	}
}
