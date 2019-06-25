package com.example.demo;

import org.springframework.stereotype.Component;

// remove when create the @bean
//@Component
public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public SwimCoach() {
		super();
	}

	
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "dont swim today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
