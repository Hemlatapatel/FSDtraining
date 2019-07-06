package com.exmaple.synchronization;

public class TwoStrings {

	static synchronized void print(String str1, String str2) {
		System.out.println(str1); 
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			
		}
		System.out.println(str2);
	}
}
