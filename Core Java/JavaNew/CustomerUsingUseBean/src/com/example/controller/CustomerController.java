package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {

	private String name;
	private String address;
	private String item;

	private CustomerService service = null;

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
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		service = new CustomerServiceImpl();
		List<String> errMsgs = new LinkedList<String>();

		name = request.getParameter("name");
		address = request.getParameter("address");
		item = request.getParameter("item");

		System.out.println("item: " + item);
		System.out.println("name : " + name);
		if (name.length() <= 0) {
			errMsgs.add(" name can not be blank");
		}

		if (address.length() <= 0) {
			errMsgs.add("Address can not be blank");
		}

		if(item.equals("UNKNOWN")) {
			errMsgs.add("Select item.");
		}

		if (!errMsgs.isEmpty()) {
			request.setAttribute("ERROR", errMsgs);

			RequestDispatcher view = request.getRequestDispatcher("createCustomer.jsp");
			view.forward(request, response);

		} else {
			System.out.println("in else");
			Customer customer = new Customer(name, address, item);
			if (service.createCustomer(customer)) {

				request.setAttribute("msg", "Customer added successfully");
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/success.jsp");
				view.forward(request, response);
			}
		}

	}
}