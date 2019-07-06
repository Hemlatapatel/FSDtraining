package com.example.dao;

import java.sql.*;

import com.example.factory.Factory;
import com.example.model.Employee;


public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection con;

	public EmployeeDAOImpl() {
		super();
		// TODO Auto-generated constructor stub

		Factory connectionFactory = Factory.getMyConnection();
		con = connectionFactory.con;
	}

	@Override
	public ResultSet getAllEmployees() {
		// TODO Auto-generated method stub
		ResultSet rs = null;

		try {

			Statement st = con.createStatement();
			rs = st.executeQuery(
					"select emp_id as 'EMPLOYEE_ID', concat(first_name, concat(' ', last_name)) as 'EMPLOYEE NAME', salary as 'SALARY' from employee");

		} catch (Exception e) {
			e.getStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet findByFirstName(String fName) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			PreparedStatement ps = con.prepareStatement(
					"select emp_id as 'EMP_ID', first_name as 'FIRST_NAME', salary as 'SALARY' from employee where first_name=?");
			ps.setString(1, fName);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet updateById(int id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;

		try {
			PreparedStatement ps = con.prepareStatement(
					"select emp_id as 'EMP_ID', first_name as 'FIRST_NAME', last_name as 'LAST_NAME' , salary as 'SALARY' from employee where emp_id=?");
			ps.setInt(1, id);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		boolean flag = false; 
		try {
			PreparedStatement ps = con
					.prepareStatement("update employee set first_name = ?, last_name = ?, salary=? where emp_id=?");
			
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setInt(3, employee.getSalary());
			ps.setInt(4, employee.getId());

			if (ps.executeUpdate() == 1) {
				System.out.println("updated");
				flag = true;
			} else {
			    flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		System.out.println("id is " + id);
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement("delete from employee where emp_id = ?");
			ps.setInt(1, id);

			if (ps.executeUpdate() == 1)
				flag = true;
			else
				flag = false;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return flag;
	}

	@Override
	public boolean insert(Employee employee) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());
			ps.setInt(4, employee.getSalary());

			if (ps.executeUpdate() == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return flag;
	}

}
