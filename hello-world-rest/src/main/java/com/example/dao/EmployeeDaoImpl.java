package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.entity.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDAO {

	JdbcTemplate jTemplate;

	public EmployeeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDaoImpl(JdbcTemplate jTemplate) {
		super();
		this.jTemplate = jTemplate;
	}

	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub

		return jTemplate.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub

				Employee emp = new Employee();
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setSalary(rs.getInt(4));
				return emp;
			}

		});
	}

	@Override
	public Employee getetEmployeeById(int id) {
		// TODO Auto-generated method stub
		try {
			return jTemplate.queryForObject("select * from employee where emp_id=?", new RowMapper<Employee>() {

				@Override
				public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Employee emp = new Employee();
					emp.setFirstName(rs.getString(2));
					emp.setLastName(rs.getString(3));
					emp.setSalary(rs.getInt(4));
					return emp;
				}

			}, id);

		} catch (DataAccessException e) {
			return null;
		}

	}

}
