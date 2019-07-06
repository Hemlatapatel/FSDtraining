package com.example.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.sql.*;

import com.example.factory.EmployeeFactory;
import com.example.model.Employee;

public class EmployeeDAOImplement implements EmployeeDAO {

	private Connection con;
	private EmployeeFactory employeeFactory = null;
	List<Employee> employeeList = null;

	public EmployeeDAOImplement() {
		super();
		employeeFactory = EmployeeFactory.getMyConnection();
		con = employeeFactory.con;
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {

			PreparedStatement ps = con.prepareStatement("insert into employee values(?, ?, ?,?)");

			ps.setInt(1, employee.getEmp_id());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());
			ps.setInt(4, employee.getSalary());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub

		employeeList = new ArrayList<Employee>();

		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");

			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				employeeList.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	public void getEmployeeByFirstName(String fName) {
		employeeList = new ArrayList<Employee>();
		Statement st = null;

		try {
			st = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from employee where  first_name = ?");
			ps.setString(1, fName);
			System.out.println(ps.executeQuery());
			ResultSet rs = ps.executeQuery();

//			
			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				employeeList.add(e);
			}
			if (employeeList.isEmpty()) {
				System.out.println("Record not found");
			} else {
				for (Employee e1 : employeeList) {
					System.out.println(e1);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void getEmployeeById(int id) {
		employeeList = new ArrayList<Employee>();
		Statement st = null;

		try {
			st = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from employee where  emp_id = ?");
			ps.setInt(1, id);
			System.out.println(ps.executeQuery());
			ResultSet rs = ps.executeQuery();

//			
			while (rs.next()) {
				Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				employeeList.add(e);
			}
			if (employeeList.isEmpty()) {
				System.out.println("Record not found");
			} else {
				for (Employee e1 : employeeList) {
					System.out.println(e1);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void updateById(int id) {
		try {

			PreparedStatement ps = con.prepareStatement("select * from employee where emp_id =?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count == 0) {
				System.out.println("No record found with employee id: " + id);
			} else {

				Scanner sc = new Scanner(System.in);
				System.out.println("First Name: ");
				String firstName = sc.next();
				System.out.println("Last Name:");
				String lastName = sc.next();
				System.out.println("Salary: ");
				int salary = sc.nextInt();

		        ps = con.prepareStatement(
						"update employee set first_name = ?, last_name = ?, salary=? where emp_id = ?");
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setInt(3, salary);
				ps.setInt(4, id);

				if (ps.executeUpdate() == 1) {
					System.out.println("Updated successfully");
				} else {
					System.out.println("Invalid id");
				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void deleteById(int id) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from employee where emp_id = ?");
			ps.setInt(1, id);
			if (ps.executeUpdate() == 1) {
				System.out.println("Deleted successfully");
			} else {
				System.out.println("Invalid id");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
