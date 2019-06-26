package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDaoImpl;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

public class EmployeeConfig {

	@Bean
	public DriverManagerDataSource dSource() {
		return new DriverManagerDataSource();
	}
	
	@Bean 
	public JdbcTemplate jTemplate() {
		return new JdbcTemplate(dSource());
	}
	
	@Bean
	public EmployeeDAO dao() {
		return new EmployeeDaoImpl(jTemplate());
	}
	
	@Bean 
	public EmployeeService service() {
		return new EmployeeServiceImpl(dao());
				
	}
	
	@Co
}
