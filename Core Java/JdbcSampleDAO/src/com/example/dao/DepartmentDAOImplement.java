package com.example.dao;

import java.sql.*;
import com.example.factory.EmployeeFactory;
import com.example.model.Department;

public class DepartmentDAOImplement implements DepartmentDAO {

	private Connection con;

	private EmployeeFactory employeeFactory = null;

	public DepartmentDAOImplement() {
		employeeFactory = EmployeeFactory.getMyConnection();
		con = employeeFactory.con;
	}

	public void createDepartment(Department department) {

		try {
			PreparedStatement ps = con.prepareStatement("insert into department values(?, ?, ?)");
			ps.setInt(1, department.getDeptId());
			ps.setString(2, department.getDeptName());
			ps.setInt(3, department.getEmpId());

			if (ps.executeUpdate() == 1) {
				System.out.println("Department inserted successfully");
			} else {
				System.out.println("Error");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void getDepartment() {
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select employee.first_name, employee.last_name, employee.salary, department.dept_name from employee inner join department on employee.emp_id = department8"
					+ ".employee_id");

			while (rs.next()) {
				System.out.println("First name:" + rs.getString(1));
				System.out.println("Last name: " + rs.getString(2));
				System.out.println("Salary : " + rs.getInt(3));
				System.out.println("department name: " + rs.getString(4));
		
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}
