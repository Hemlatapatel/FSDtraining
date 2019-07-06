package com.serializable.student;
import java.io.*;

public class MainApp {
	public static void main(String args[]) {
		
		Student student = new Student();
		student.setId("100");
		
		student.setName("Hemlata");
		student.setAddress("Indore");
		student.setCourse(new Course("java for dummies", "$400"));
		
		try {
			FileOutputStream fos = new FileOutputStream("Objectstore2.txt");
			
			ObjectOutputStream ous = new ObjectOutputStream(fos);
			ous.writeObject(student);
			
			System.out.println("Object written---");
			
			FileInputStream fis = new FileInputStream("Objectstore2.txt");
			ObjectInputStream ois = new 	ObjectInputStream(fis);
			Object o = ois.readObject();
			
			student  = (Student)o;
			
			System.out.println(student);
			
			
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
}
