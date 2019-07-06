package com.example;

public class JoinTest {

	public static void main(String args[]) {
		PrintThreadNameRunnable pnt1 = new PrintThreadNameRunnable("A");
		PrintThreadNameRunnable pnt2 = new PrintThreadNameRunnable("B");
		PrintThreadNameRunnable pnt3 = new PrintThreadNameRunnable("C");
//		
//		Thread t1 = new Thread(pnt1);
//		Thread t2 = new Thread(pnt2);
//		Thread t3 = new Thread(pnt3);

		System.out.println("Running threads............");

		
//		t2.start();
		try {
//		t2.join();
			
			pnt1.thread.join();
			pnt2.thread.join();
			pnt3.thread.join();
		} catch(InterruptedException e) {
			
		}
//		t1.start();
//		t3.start();
	}
}
