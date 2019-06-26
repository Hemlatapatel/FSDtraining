package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	Scanner sc = new Scanner(System.in);

	public EmployeeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub

		jdbcTemplate.update("insert into employee values(?,?,?,?)", employee.getId(), employee.getFirstName(),
				employee.getLastName(), employee.getSalary());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setSalary(rs.getInt(4));
				return employee;
			}
		});
	}

	@Override
	public Employee getEmpoyeeById(int id) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("select * from employee where emp_id=?", new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee employee = new Employee();
					employee.setId(rs.getInt(1));
					employee.setFirstName(rs.getString(2));
					employee.setLastName(rs.getString(3));
					employee.setSalary(rs.getInt(4));

					return employee;
				}

			}, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public String updateEmployeeById(int id) {
		// TODO Auto-generated method stub

		System.out.println("First Name: ");
		String fName = sc.next();

		System.out.println("Last Name: ");
		String lName = sc.next();
		System.out.println("Salary: ");
		int salary = sc.nextInt();

		Employee employee = new Employee(id, fName, lName, salary);
		jdbcTemplate.update("update employee set first_name=?, last_name=?,salary=? where emp_id=?",
				employee.getFirstName(), employee.getLastName(), employee.getSalary(), employee.getId());
		return null;
	}

	@Override
	public List<Employee> getEmployeeByName(String fName) {
		// TODO Auto-generated method stub
		
		try {
			return jdbcTemplate.query("select * from employee where first_name=?", new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee employee = new Employee();
					employee.setId(rs.getInt(1));
					employee.setFirstName(rs.getString(2));
					employee.setLastName(rs.getString(3));
					employee.setSalary(rs.getInt(4));

					return employee;
				}

			}, fName);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}	
	}
}
