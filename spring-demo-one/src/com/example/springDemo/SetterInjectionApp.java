package com.example.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionApp {
	public static void main(String args[]) {
		
		/*
		 * example of Injecting literal value
		 */	
		//ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("setter-applicationContext.xml");
		
		//		CricketCoach myCoach = context.getBean("myCricketCoach", CricketCoach.class);
	
		//		System.out.println("email============" + myCoach.getEmailAddress());
		//		System.out.println("team===================" + myCoach.getTeam());
		//		System.out.println("workout====" + myCoach.getDailyWorkout());
		//		System.out.println("fortune========" + myCoach.getDailyFortune());
		
		
		 /*	example of injecting values from property file
		  */		
		 ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("properties-applicationContext.xml");

		TennisCoach tennisCoach = context.getBean("myTennisCoach", TennisCoach.class);
		//		System.out.println("email============ " + tennisCoach.getEmailAddress());
		//		System.out.println("team============= " + tennisCoach.getTeam());
		//		System.out.println("workout====" + tennisCoach.getDailyWorkout());
		//	
		TennisCoach alphaCoach = context.getBean("myTennisCoach", TennisCoach.class);
		
		/*
		 * bydefault the scope of bean is singleton means all object refer to the same memory address
		 */
		boolean result = (tennisCoach==alphaCoach);
		System.out.println("The tennisCoach and alphaCoach refer to the same object ? " + result);
		System.out.println("Memory location of the tennisCoach: " + tennisCoach);
		System.out.println("Memory location of the alphaCoach: " + alphaCoach);

		
		context.close();
	}

}
