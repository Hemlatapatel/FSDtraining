package com.example.teamProgram;

public class Team {
	private String name;
	private String coach;
	private String location;
	private String players;
	private String captain;

	public Team(String name, String coach, String location, String players, String captain) {
		super();
		this.name = name;
		this.coach = coach;
		this.location = location;
		this.players = players;
		this.captain = captain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public void displayTeamDetails() {
	    System.out.println("Team details");
		System.out.println("Team : " + getName());
		System.out.println("Coach : " + getCoach());
		System.out.println("Location : " + getLocation());
		System.out.println("Players : " + getPlayers());
		System.out.println("Captain : " + getCaptain());
	}
}
