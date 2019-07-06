package com.example.priority;

public class ThreadPriority {

	public static void main(String args[]) {
		SimpleThread st1 = new SimpleThread("Boston");
		// set the highest priority
		st1.start();
		st1.setPriority(10);
		
		SimpleThread st2 = new SimpleThread("Newyork");
		st2.start();
		// set the normal priority
		st2.setPriority(5);
		
		SimpleThread st3 = new SimpleThread("USA");
		st3.start();
		// set the highest priority
		st3.setPriority(1);
		
		try {
			st2.join();
		} catch(InterruptedException e) {
			
		}
		
		SimpleThread st4 = new SimpleThread("India");
		st4.start();
		// bydefault the priority will be normal(5)
	}
}
