package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DOGCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "it is the dogCoach instructions....";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
