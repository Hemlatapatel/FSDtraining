package com.example.app;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.service.DepartmentServiceImplement;
import com.example.service.EmployeeServiceImplement;
import com.example.dao.EmployeeDAOImplement;
import com.example.factory.*;
import java.util.*;
import java.sql.*;

public class MyJdbcApp {
    static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
	
		// this is for DAO 
//		EmployeeDAOImplement impl = new EmployeeDAOImplement();
//		List<Employee> list = impl.getAllEmployee();
//		
//		for(Employee e:list)
//		{
//			System.out.println(e);
//		}
		
		
		EmployeeServiceImplement service = new EmployeeServiceImplement();
		 service.getAllEmployees();
		 
		 DepartmentServiceImplement deptService = new DepartmentServiceImplement();
		 
		 int choice = 0;
		 do {
			 System.out.println("1.Insert");
			 System.out.println("2: Display All");
			 System.out.println("3: Find By first name");
			 System.out.println("4: Update by id");
			 System.out.println("5: delete by id");
			 System.out.println("6: find by id");
			 System.out.println("7: Insert into department");
			 System.out.println("8: Get department");
			 System.out.println("0: Exit");
			 
			 System.out.println("Enter your choice: ");
			 choice  = sc.nextInt();
			 
			 switch(choice) {
			 case 1: 
				 System.out.println("Employee id: ");
				 int emp_id = sc.nextInt();
				 System.out.println("First Name: ");
				 String firstName = sc.next();
				 System.out.println("Last Name:");
				 String lastName = sc.next();
			     System.out.println("Salary: ");
			     int salary = sc.nextInt();
			     
			     Employee employee = new Employee(emp_id, firstName, lastName, salary);
			     
			     service.createEmployee(employee);
			     System.out.println("Inserted successfully!");
			     break;
			     
			 case 2: 
				 System.out.println("All the employees: ");
				 service.getAllEmployees();
				 break;
				 
			 case 3: 
				System.out.println("Enter a first name to search: ");
				String fName = sc.next();
				service.getEmployeeByFirstName(fName);
				break;
				
				
			 case 4: 
				 System.out.println("Enter Id to update data:  ");
				 int id= sc.nextInt();
				
				 service.updateById(id);
				 break;
				 
			 case 5: 
				 System.out.println("Enter id to delete data: ");
				 id = sc.nextInt();
				 service.deleteById(id);
				 break;
				
			 case 6: 
				 System.out.println("Enter id to find: ");
				 id = sc.nextInt();
				 service.getEmployeeById(id);
				 break;
				 
			 case 7: 
				 System.out.println("Enter department id: ");
				 int deptId  = sc.nextInt();
				 System.out.println("Enter department name: ");
				 String deptName = sc.next();
				 System.out.println("Enter Employee id");
				 int empId = sc.nextInt();
				 
			     Department department = new Department(deptId, deptName, empId);	
			     deptService.createDepartment(department);
			     break;
			     
			 case 8: 
				 deptService.getDepartment();
				 
			
			 case 0:
			 System.out.println("byeee");
			 System.exit(0);
			 
			 default: 
				 System.out.println("Invalid choice");
				 break;
			 }
			 
		 } while(choice != 0);
	}
}
