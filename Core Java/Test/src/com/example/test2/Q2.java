package com.example.test2;

interface Foo {
}

class Alpha implements Foo {
}

class Beta extends Alpha {
}

class Q2 extends Beta {
		public static void main(String[] args) {
			Beta x = new Beta();
			// insert code here
			
			
			Alpha a = x;
			Foo f1 = (Q2) x;
			Foo f2 = (Alpha) x;
			Beta b = (Beta)(Alpha)x;
		}
}



	