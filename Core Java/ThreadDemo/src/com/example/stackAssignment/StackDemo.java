package com.example.stackAssignment;

public class StackDemo {

	public String stack[] = new String[10];

	int top = -1;

	public synchronized void push(String str) {

	   if (top == stack.length) {
			try {
				wait();
//				System.out.println("overflow");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			top = top + 1;
			stack[top] = str;
//			System.out.println("element added successfully");
			notifyAll();
		}
	}

	public synchronized String pop() {
		String temp = null;
		if (top == -1) {
			try {
				wait();
//				System.out.println("Underflow");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			temp = stack[top];
			stack[top] = null;
			top = top - 1;
//			System.out.println("Removed item is : " + temp);
			notifyAll();
		}
		return temp;
	}

	public void show() {

	}
}
