package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.*;

public class UserDaoImpl implements UserDAO {

	private JdbcTemplate jTemplate;

	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		try {
			return jTemplate.queryForObject("select * from userlogin where user_id=? and password=?", new RowMapper<User>() {

			
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setUserName(rs.getString(1));
					user.setPassword(rs.getString(2));
					return user;
				}

			}, user.getUserName(), user.getPassword());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
