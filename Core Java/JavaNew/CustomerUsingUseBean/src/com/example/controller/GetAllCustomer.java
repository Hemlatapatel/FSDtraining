package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.example.model.Customer;

@WebServlet("/GetAllCustomer")

public class GetAllCustomer extends HttpServlet {

	private CustomerService service = null;
	int id;
	String name;
	String address;
	String item;
	Customer customer;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		service = new CustomerServiceImpl();

		ResultSet rs = service.getAllCustomer();
		List<Customer> custList = new ArrayList<Customer>();
		
		int count = 0;
		try {
			while (rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				address = rs.getString(3);
				item = rs.getString(4);
				custList.add(new Customer(id,name, address, item));
			}
		} catch (Exception e) {

		}
		request.setAttribute("custList", custList);
		RequestDispatcher view = request.getRequestDispatcher("/list_customer.jsp");
		view.forward(request, response);

	}
}
