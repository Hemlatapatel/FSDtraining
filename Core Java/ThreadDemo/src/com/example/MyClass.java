package com.example;

public class MyClass implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 40; i++) {
			System.out.println(Thread.currentThread() + ">>" + i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
	
    public static void main(String args[]) {
    	MyClass m1 = new MyClass();
    	Thread t1 = new Thread(m1);
    	Thread t2 = new Thread(m1);
    	t1.start();
    	t2.start();
    	
    }
}
