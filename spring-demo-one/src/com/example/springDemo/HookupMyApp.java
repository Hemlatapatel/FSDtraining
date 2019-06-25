package com.example.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HookupMyApp {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hookup-applicationContext.xml");
		
		TennisCoach tennisCoach = context.getBean("myCoach", TennisCoach.class);
	    
		System.out.println(tennisCoach.getDailyWorkout());
		
		System.out.println(tennisCoach.getEmailAddress());

		context.close();
	}
}
