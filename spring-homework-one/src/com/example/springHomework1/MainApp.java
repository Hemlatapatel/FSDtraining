package com.example.springHomework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String args[]) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach = context.getBean("myGolfCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		context.close();
		
		
	}
}
