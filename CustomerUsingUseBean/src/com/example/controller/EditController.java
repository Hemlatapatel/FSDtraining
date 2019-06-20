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


@WebServlet("/EditController")
public class EditController extends HttpServlet {

	private CustomerService service = null;
	private int id;
	private String name;
	private String address;
	private String item;
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		out.println("id : " + id);
		name = request.getParameter("name");
		address = request.getParameter("address");
		item = request.getParameter("item");

		
		
		if (name.length() <= 0) {
			errMsgs.add(" name can not be blank");
		}

		if (address.length() <= 0) {
			errMsgs.add("Address can not be blank");
		}

		if(item.length() <= 0) {
			errMsgs.add("Select item.");
		}

		if (!errMsgs.isEmpty()) {
			request.setAttribute("ERROR", errMsgs);

			RequestDispatcher view = request.getRequestDispatcher("createCustomer.jsp");
			view.forward(request, response);

		} else {
			
			Customer customer = new Customer(id, name, address, item);
			
			if (service.updateById(customer)) {
////				request.setAttribute("msg", "Customer updated succes sfully");
//				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/success.jsp");
//				view.forward(request, response);
				
				RequestDispatcher view = request.getRequestDispatcher("GetAllCustomer");
				view.forward(request, response);
			}
		}
		
	}

}
