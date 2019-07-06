package com.example.player;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class TestMain {

	public static void main(String args[]) {

		Map<String, Integer> playerMap = new HashMap<String, Integer>();
		int choice = 0;
		String check = null;
		String keyCheck = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Display");
			System.out.println("0. Exit");

			System.out.println("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				do {
					System.out.println("Enter the player name: ");
					String player = sc.next();

					String wicketArray[] = null;

					System.out.println("Enter the wickets separated by | ");

					String wickets = sc.next();

					wicketArray = wickets.split(Pattern.quote("|"));

					int wicketCount = 0;
					for (String wicket : wicketArray) {
						wicketCount++;
					}

					playerMap.put(player, wicketCount);
					System.out.println("Do you want to add another player: ");
					check = sc.next();

				} while (check.equalsIgnoreCase("yes"));
				break;

			case 2:
				do {
					boolean flag = false;
					System.out.println("Enter the player name to be searched: ");
					String key = sc.next();

					Set<Entry<String, Integer>> entrySet = playerMap.entrySet();

					Iterator<Entry<String, Integer>> itr = entrySet.iterator();

					while (itr.hasNext()) {
						Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) itr.next();

						// Check if this key is the required key
						if (entry.getKey().equalsIgnoreCase(key)) {

							System.out.println("Player Name is: " + entry.getKey());
							System.out.println("Wicket count is: " + entry.getValue());
							flag = true;
							break;

						} else {
							flag = false;
						}
					}
					if (!flag) {
						System.out.println("No player found of this name.. ");
					}

					System.out.println("Do you want to find another player: ");
					keyCheck = sc.next();
					if (keyCheck.equalsIgnoreCase("no")) {
						System.out.println("Thanks..");
						break;
					}

				} while (keyCheck.equalsIgnoreCase("yes"));
				break;

			case 3:
				System.out.println("Map is : " + playerMap);
				break;

			case 0:
				System.out.println("Bye...");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 0);

	}
}
