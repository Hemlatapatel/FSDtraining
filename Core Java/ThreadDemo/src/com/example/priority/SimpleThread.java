package com.example.priority;

public class SimpleThread extends Thread{

	public SimpleThread(String str) {
		super(str);
	}
	 
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(i + " " + getName() + " priority = " + getPriority());
		}
		System.out.println("Done : " + getName());
	}
}
