package com.example.stackAssignment;

import java.util.Scanner;

public class StackMain {

	public static void main(String args[]) {
		StackDemo sd = new StackDemo();
		
		StackPush push= new StackPush("test");
		
		StackPop pop = new StackPop();
		
		push.start();
		pop.start();
		
		int choice = 0;
//		do {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("1. Push");
//			System.out.println("2. Pop");
//			System.out.println("0. Exit");
//			
//			System.out.println("Enter your choice: ");
//			choice = sc.nextInt();
//			
//			switch(choice) {
//			case 1: 
//				
//				System.out.println("Enter a String");
//				String s = sc.next();
//				sd.push(s);
//				break;
//			
//			case 2: 
//				String top = sd.pop();
//			    System.out.println("removed element is : " + top);
//			    break;
//			
//			
//			case 0:
//				System.out.println("bye...");
//				break;
//				
//			default: 
//				System.out.println("Invalid choice");
//				break;
//			}	
//			
//		} while(choice != 0);
	}
}
