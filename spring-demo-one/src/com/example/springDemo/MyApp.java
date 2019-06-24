//package com.example.springDemo;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class MyApp {
//
//	public static void main(String args[]) {
//		
//		// step 1: get the applicationContext
//
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//		// step 2: get the bean
//
//		//Coach myCoach = context.getBean("myTrackCoach", Coach.class);
//		Coach myCoach2 = context.getBean("myBaseBallCoach", Coach.class);
//		
//		// step 3: call the appropriate method
//		System.out.println(myCoach2.getDailyWorkout());
//
//		System.out.println(myCoach2.getDailyFortune());
//		
//		
//		// step 4: close the context
//		context.close();
//	}
//}
