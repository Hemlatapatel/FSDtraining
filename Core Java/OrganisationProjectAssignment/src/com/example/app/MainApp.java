package com.example.app;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.model.Employee;

public class MainApp {

	public static void main(String args[]) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> org = new HashMap<String, Integer>();
		int choice = 0;
		do {

			System.out.println("1. Add Employee");
			System.out.println("2. Show Employee");
			System.out.println("3. Show Organization");
			System.out.println("0. Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter the name: ");
				String name = sc.next();

				System.out.println("Enter gender: ");
				String sex = sc.next();

				System.out.println("Enter Job title: ");
				String jobTitle = sc.next();

				System.out.println("Enter Organisation: ");
				String organisation = sc.next();

				System.out.println("Enter birth date in format (yyyy-mm-dd)");

				String date = sc.next();
				Date birthday = Date.valueOf(date);

				Employee employee = new Employee(name, sex, jobTitle, organisation, birthday);

				System.out.println("org" + employee.getOrganisation());
				if (employeeList.add(employee)) {
					if ((employee.getOrganisation()).equals("google")) {
						if (org.containsKey("google")) {
							int value = org.get("google");
							value = value + 1;
							org.put("google", value);
						} else {
							org.put("google", 1);
						}
					} else {
						if (org.containsKey("microsoft")) {
							int value = org.get("microsoft");
							value = value + 1;
							org.put("microsoft", value);
						} else {
							org.put("microsoft", 1);
						}
					}
				}

				break;

			case 2:
				System.out.println("Employee" + employeeList);
				break;

			case 3:
				System.out.println("Organisation" + org);
				break;

			case 0:
				System.out.println("Bye....");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice");
				break;
			}

		} while (choice != 0);
	}
}
