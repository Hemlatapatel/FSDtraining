package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {

	private CustomerService service = null;

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
		int id = 0;
		try {
			id = Integer.parseInt( request.getParameter("id"));

		} catch(Exception e) {
			e.printStackTrace();
		}
		if (service.deleteById(id)) {

//			request.setAttribute("msg", "Customer deleted successfully");
//			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/success.jsp");
//			view.forward(request, response);
			
			RequestDispatcher view = request.getRequestDispatcher("GetAllCustomer");
			view.forward(request, response);
		}
	}

}
