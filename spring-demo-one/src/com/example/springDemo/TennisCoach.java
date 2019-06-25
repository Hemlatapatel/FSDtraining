package com.example.springDemo;

public class TennisCoach implements Coach{
	
	private String emailAddress;
	private String team;
	
	

	public TennisCoach() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do yoga daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

	public void doMyInitStuff() {
		System.out.println("TennisCoach: inside the doMyInitStuff");
	}
	
	
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside the diMycleanupStuff");
	}
	
	
	
	
	
	}
