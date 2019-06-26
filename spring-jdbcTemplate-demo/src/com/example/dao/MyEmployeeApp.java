package com.example.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.EmployeeConfig;
import com.example.model.Employee;
import com.example.service.EmployeeService;

public class MyEmployeeApp {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice=0;
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		EmployeeDAO dao = context.getBean("eDao", EmployeeDAO.class);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeService service = context.getBean("service", EmployeeService.class);

		do {
			System.out.println("1. add employee");
			System.out.println("2. Find employee by id:");
			System.out.println("3. Display all employee");
			System.out.println("4. Update the data");
			System.out.println("5. Find employee by first Name");
			System.out.println("0. Exit employee management system");
			System.out.println("Enter your choice: ");
			
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: 
				System.out.println("Enter the Employee details");
				System.out.println("Id: ");
				int id = sc.nextInt();
				System.out.println("First Name: ");
				String fName = sc.next();
				
				System.out.println("Last Name: ");
				String lName = sc.next();
				System.out.println("Salary: ");
				int salary = sc.nextInt();
				
				Employee employee = new Employee(id, fName, lName, salary);
//				dao.addEmployee(employee);
				service.addEmployee(employee);
				System.out.println("Employee added successfully");
				break;
				
			case 2: 
				System.out.println("Enter the employee id to be searched: ");
				id = sc.nextInt();
//				Employee emp = dao.getEmpoyeeById(id);
				Employee emp = service.getEmpoyeeById(id);

				if(emp!=null) {
					System.out.println(emp);
				} else {
					System.out.println("No employee found of this id");
				}
				
				break;
				
			case 3: 
//				List<Employee> list = dao.getAllEmployees();
				List<Employee> list = service.getAllEmployees();

				
				for(Employee e: list) {
					System.out.println(e);
				}
				break;
				
			case 4: 
				System.out.println("Enter the employee id: ");
				id = sc.nextInt();
//				employee = dao.getEmpoyeeById(id);
				employee = service.getEmpoyeeById(id);

				if(employee!=null) {
					
//					dao.updateEmployeeById(id);
					service.updateEmployeeById(id);
					System.out.println("Employee updated successfully");
				} else {
					System.out.println("No employee found of this id");
				}
				
				break;
				
			
			case 5: 
				System.out.println("Enter the employee first name to be searched: ");
				fName = sc.next();
//				list = dao.getEmployeeByName(fName);
				list = service.getEmployeeByName(fName);

				for(Employee e: list) {
					System.out.println(e);
				}
		
				break;
			case 0: 
				System.out.println("Bye");
				System.exit(0);
				
			
			default:
				System.out.println("Invalid choice");
				break;
				
			}
			
		} while(choice!=0);
	}
}
