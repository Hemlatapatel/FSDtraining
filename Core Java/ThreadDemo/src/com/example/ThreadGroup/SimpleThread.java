package com.example.ThreadGroup;

public class SimpleThread extends Thread {
	public SimpleThread(String str) {
		super(str);
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sleep((long)(Math.random() * 1000));
			} catch(InterruptedException e) {
				
			}
		}
		
		System.out.format("Done %s%n " ,getName() );
	}
}
