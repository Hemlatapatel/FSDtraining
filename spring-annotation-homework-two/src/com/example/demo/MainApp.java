package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String args[]) {
		// configure using xml file
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// configure using java file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);

		Customer customer = context.getBean("customer", Customer.class);
		
		System.out.println("Human details===>  "+ customer.getHumanDetails());
		
		System.out.println("Customer name========>  " + customer.getCustomerName());
		
		System.out.println("Customer id=====>  "+ customer.getCustomerId());
		
		System.out.println("address =====>  "+ customer.getAddress());
		
		context.close();
		
	}
}
