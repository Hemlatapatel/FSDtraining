package com.example.springHomework1;

public class GolfCoach implements Coach {
	
	private FortuneService fortuneService;
	

	public GolfCoach() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}



	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice your putting skills for 2 hrs. daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
