package com.example.springDemo;

public class HappyFortuneService implements FortuneService {
	
	public HappyFortuneService() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Happy FortuneService: object created! ");
	}

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
}
