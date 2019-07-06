package com.example.teamProgram;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the team name: ");
		String name = sc.next();
		
		System.out.println("Enter the coach name: ");
		String coach = sc.next();
		
		System.out.println("Enter the location: ");
		String location = sc.next();
		
		System.out.println("Enter the captain name: ");
		String captain = sc.next();
		
		System.out.println("Enter the players(, separated) : ");
		String players = sc.next();
		
		Team team = new Team(name, coach, location, captain, players);
		
		team.displayTeamDetails();
	}
}
