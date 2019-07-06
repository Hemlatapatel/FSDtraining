package com.example;

public class PrintNameThreadMain {
	public static void main(String args[]) {
		System.out.println("creating PrintNameThread object instance......");
		PrintNameThread pn1 = new PrintNameThread("A");

		// start the thread by invoking the start() method
		System.out.println("calling start() method of " + pn1.getName() + " thread");

		pn1.start();

		System.out.println("creating PrintNameThread object instance......");
		PrintNameThread pn2 = new PrintNameThread("B");

		// start the thread by invoking the start() method
		System.out.println("calling start() method of " + pn2.getName() + " thread");

		pn2.start();

		System.out.println("creating PrintNameThread object instance......");
		PrintNameThread pn3 = new PrintNameThread("C");

		// start the thread by invoking the start() method
		System.out.println("calling start() method of " + pn3.getName() + " thread");

		pn3.start();

	}
}
