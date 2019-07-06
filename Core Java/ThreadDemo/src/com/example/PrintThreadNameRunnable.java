package com.example;

public class PrintThreadNameRunnable  implements Runnable{

	Thread thread;
	public PrintThreadNameRunnable(String name) {
		thread = new Thread(this, name);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = thread.getName();
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread()+name);
		}
	}

}
