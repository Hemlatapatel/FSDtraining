package com.example.dao;

import java.sql.*;

import com.example.factory.MyConnectionFactory;
import com.example.model.Customer;

public class CustomerDAOImpl implements CustomerDao {

	private Connection connection;
	private MyConnectionFactory myConnectionFactory;

	public CustomerDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
		myConnectionFactory = myConnectionFactory.getMyConnectionFactory();
		connection = myConnectionFactory.connection;
	}

	@Override
	public boolean createCustomer(Customer customer) {

		boolean flag = false;

		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into customer_detail(name, address, item) values(?,?,?)");

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getItem());
			if (ps.executeUpdate() == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return flag;
	}

	@Override
	public ResultSet getAllCustomer() {
		// TODO Auto-generated method stub
		ResultSet rs = null;

		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery("select * from customer_detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean updateById(Customer customer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try {
			PreparedStatement ps = connection.prepareStatement("update customer_detail set name=?, address=?,item=? where id=?");
			
			ps.setString(1, customer.getName());
			ps.setString(2,  customer.getAddress());
			ps.setString(3, customer.getItem());
			ps.setInt(4,  customer.getId());
			
			if(ps.executeUpdate() == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			PreparedStatement ps= connection.prepareStatement("delete from customer_detail where id=?");
			ps.setInt(1,  id);
			
			if(ps.executeUpdate() == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
