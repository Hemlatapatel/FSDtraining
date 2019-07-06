package com.example.app;
import com.example.model.Employee;
import com.example.factory.*;
import java.util.*;
import java.sql.*;

public class MyJdbcApp {

	public static void main(String args[]) {
		
		List <Employee> list = new ArrayList<Employee> ();		

		EmployeeFactory eFactory = null;
		
		try {
			//-----------------------------------------------------
			// previous
			// eFactory  = new EmployeeFactory();
			// Connection con  = eFactory.getMyConnection();
			//-----------------------------------------------------
			
			// singleton
			eFactory = eFactory.getMyConnection();
			Connection con = eFactory.con;
	
			// Connection con = EmployeeFactory.con; // we can direct call using class name
			
			
			// step 3
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from employee");
			
			while(rs.next()) {
				/*
				 * System.out.println("Emp id: "+ rs.getInt(1)) ;
				 * System.out.println("First name : " + rs.getString(2));
				 * System.out.println("Last name: " + rs.getString(3));
				 * System.out.println("Salary: " + rs.getInt(4));
				 */
			Employee employee=new Employee(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4));
			list.add(employee);
		
			
			}	
			
		
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		
		
		for(Employee e:list)
		{
			System.out.println(e);
		}
		 
	}
}
