package com.example;

public class PrintNameThread extends Thread {
	PrintNameThread(String name) {
		super(name);
	}

	public void run() {
		String name = getName();
		for (int i = 0; i < 100; i++) {
			System.out.print(name);
		}

	}
}
