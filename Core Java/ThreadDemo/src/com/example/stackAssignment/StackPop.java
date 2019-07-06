package com.example.stackAssignment;

public class StackPop extends Thread {

	StackDemo sd = new StackDemo();
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			String str = sd.pop();
			System.out.println("removed elements is: " + str);
		}
		
	}
}
