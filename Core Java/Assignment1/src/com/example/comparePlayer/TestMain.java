package com.example.comparePlayer;
import java.util.*;


public class TestMain {

	public static void main (String args[]) {
		List<Player> playerList = new ArrayList<Player>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the player 1 details");
		System.out.println("Enter the name: ");
		String name1 = sc.next();
		
		System.out.println("Enter the country: ");
		String country1 = sc.next();
		
		System.out.println("Enter the skill");
		String skill1 = sc.next();
		
		Player player1 = new Player(name1, country1, skill1);
	
		System.out.println("Enter the player 2 details");
		System.out.println("Enter the name: ");
		String name2 = sc.next();
		
		System.out.println("Enter the country: ");
		String country2 = sc.next();
		
		System.out.println("Enter the skill");
		String skill2 = sc.next();
		
		Player player2 = new Player(name2, country2, skill2);
		
		if(player1.equals(player2)) 
			System.out.println("Both the players are same.");
		else
			System.out.println("Both players are different.");
	}
}
