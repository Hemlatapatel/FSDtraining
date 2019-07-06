package com.example.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.example.factory.CustomerFactory;
import com.example.model.Customer;

public class CustomerDAOImplement implements CustomerDAO {

	private Connection con;

	private CustomerFactory cFactory;

	public CustomerDAOImplement() {
		super();
		cFactory = cFactory.getMyConnection();
		con = cFactory.con;
	}

	@Override
	public void createCustomer() {
		// TODO Auto-generated method stub

		try {
			FileReader in = new FileReader("customer.txt");

			BufferedReader bufferReader = new BufferedReader(in);
			String l;

			PreparedStatement ps = con.prepareStatement("insert into customer values(?, ?, ?)");
			while ((l = bufferReader.readLine()) != null) {
				System.out.println(l);

				String arr[] = l.split(",");
				System.out.println("arr " + arr);
				Customer c = new Customer(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));

				ps.setInt(1, c.getId());
				ps.setString(2, c.getName());
				ps.setInt(3, c.getAmount());
				ps.executeUpdate();

			}
			bufferReader.close();
			in.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void writeObjectToFile() {

		List<Customer> customerList = new ArrayList<Customer>();
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer");

			Customer c = null;
			while (rs.next()) {
				c = new Customer(rs.getInt(1), rs.getString(2), rs.getInt(3));
				customerList.add(c);
				System.out.println("customer=====" + c);
				
				// write object to file
				FileOutputStream fos = new FileOutputStream("ObjectStore.txt");
				
				ObjectOutputStream ous = new ObjectOutputStream(fos);
				
				ous.writeObject(c);
				
				System.out.println("Object written-----");
				
				FileInputStream fis = new FileInputStream("ObjectStore.txt");
				
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o = ois.readObject();
				
				c = (Customer)o;
				
				System.out.println(c);
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
