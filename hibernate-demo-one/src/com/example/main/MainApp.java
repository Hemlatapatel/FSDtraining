package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.err;

import com.example.entity.Student;
import com.example.service.StudentService;
import com.example.service.StudentserviceImpl;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(in);
		StudentserviceImpl service = new StudentserviceImpl();
		Student student = null;
		List<Student> studentList = null;
		int choice = 0;
		try {
			do {
				out.println("1. Insert");
				out.println("2. Display all");
				out.println("3. Get by Id");
				out.println("4. get by first Name");
				out.println("5. get by last name");
				out.println("6. Delete");
				out.println("7. Update");
				out.println("0.exit");

				out.println("Enter your choice: ");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					out.println("First Name: ");
					String firstName = sc.next();
					out.println("Last Name");
					String lastName = sc.next();
					out.println("Email: ");
					String email = sc.next();
					student = new Student(firstName, lastName, email);
					service.createStudent(student);
					break;

				case 2:

					studentList = service.getAllStudent();
					for (Student s : studentList) {
						out.println(s);
					}

					break;

				case 3:
					out.println("Enter the id to be searched: ");
					int id = sc.nextInt();
					student = service.getStudentById(id);
					out.println(student);
					break;

				case 4:
					out.println("Enter first name to be searched");
					firstName = sc.next();
					studentList = service.getStudentByName(firstName);
					for (Student s : studentList) {
						out.println(s);
					}
					break;

				case 5:
					out.println("Enter last name to be searched");
					lastName = sc.next();
					studentList = service.getStudentByLastName(lastName);
					for (Student s : studentList) {
						out.println(s);
					}
					break;

				case 6:
					out.println("Enter id to be deleted: ");
					id = sc.nextInt();
					service.deleteById(id);
					out.println("deleted successfully");
					break;

				case 7:
					out.println("Enter the id to be update: ");
					id = sc.nextInt();
					service.updateById(id);
					out.println("updated successfully");
					break;

				case 0:

					out.println("Bye...");
					System.exit(0);

				default:
					out.println("Invalid choice");
					break;
				}

			} while (choice != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
