package com.example.springDemo;

public class BaseBallCoach implements Coach{

	private FortuneService fortuneService;
	
	
	public BaseBallCoach() {
		super();
		System.out.println("Baseball object created");
	}

    // called when constructor dependency injection is created.
	public BaseBallCoach(FortuneService fortuneService) {
	
		this.fortuneService = fortuneService;
		System.out.println("BaseballCoach: Constructor Dependency injection performed");
	}


	@Override
	public String getDailyWorkout() {
		return "Do backhead 30 times daily";
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("BaseBallCoach: setter injection performed");
	}
	
	
}