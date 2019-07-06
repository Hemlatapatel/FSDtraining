package com.example.comparePlayer;

public class Player {

	String name;
	String country;
	String skill;

	public Player(String name, String country, String skill) {
		super();
		this.name = name;
		this.country = country;
		this.skill = skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Player) {
			Player p1 = (Player) obj;
			if ((p1.getName().equals(name) && p1.getCountry().equals(country) && p1.getSkill().equals(skill))) {
				return true;
			}
		}
		return false;
	}

}
