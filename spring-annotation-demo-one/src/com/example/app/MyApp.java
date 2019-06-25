package com.example.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springdemo.Coach;
import com.example.springdemo.FootballCoach;

public class MyApp {

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Coach myCoach  = context.getBean("theCoach", Coach.class);
		
		// bydefault the name of the bean is footballCoach
		// Coach footballCoach  = context.getBean("footballCoach", Coach.class);

		// if the class name has more than one consecutive capital letter then the default bean id is similar to the class name
		/*
		 * Coach dogCoach = context.getBean("DOGCoach", Coach.class);
		 * System.out.println(dogCoach.getDailyWorkout());
		 */
		
		
		// example of @Autowired
		/*
		 * Coach footballCoach = context.getBean("footballCoach", Coach.class);
		 * 
		 * System.out.println(footballCoach.getDailyWorkout());
		 * System.out.println(footballCoach.getDailyFortune());
		 */

		// exmaple of value annotation
		FootballCoach footballCoach = context.getBean("footballCoach", FootballCoach.class);
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		
		System.out.println(footballCoach.getEmailAddress());
		System.out.println(footballCoach.getTeam());

		
		context.close();
	}
}
