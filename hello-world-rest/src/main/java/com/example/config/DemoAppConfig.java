package com.example.config;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.dao.EmployeeDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example")
public class DemoAppConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource bds = new DriverManagerDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/sample");
		bds.setUsername("root");
		bds.setPassword("root");

		return bds;
	}
	
	@Bean
	public JdbcTemplate jTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public EmployeeDaoImpl dao() {
		return new EmployeeDaoImpl(jTemplate());
	}
	
}
