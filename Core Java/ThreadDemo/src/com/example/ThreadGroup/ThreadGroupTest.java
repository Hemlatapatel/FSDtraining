package com.example.ThreadGroup;

public class ThreadGroupTest {

	public static void main(String args[]) {
		// start three threads first. They should belongs to samr ThreadGroup
		new SimpleThread("India").start();
		new SimpleThread("USA").start();
		new SimpleThread("China").start();
		
		// get the ThreadGroup of current thread and display the no. of active thread that belongs to ThreadGroup
		
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		System.out.println("No. of active thread in ThreadGroup is : "+ group.activeCount());
		
		// Display the name of the threads in the current ThreadGroup
		Thread[] tarray = new Thread[10];
		int actualSize = group.enumerate(tarray);
		
		for (int i = 0; i < actualSize; i++) {
			System.out.println("Thread " + tarray[i].getName() + " in threadGroup : "
					+ "" + group.getName());
		}
 
	}
}
