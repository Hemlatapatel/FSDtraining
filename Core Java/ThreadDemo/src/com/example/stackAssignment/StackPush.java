package com.example.stackAssignment;

public class StackPush extends Thread {

	StackDemo sd = new StackDemo();
	String str;
	public StackPush(String str) {
		this.str = str;
		
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			sd.push(str);
		}
	}
}
