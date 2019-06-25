package com.example.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springdemo.Coach;

public class MainApp {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("footballCoach", Coach.class);
		
		System.out.println(myCoach.getDailyFortune());
		
		context.close();
	}
}
