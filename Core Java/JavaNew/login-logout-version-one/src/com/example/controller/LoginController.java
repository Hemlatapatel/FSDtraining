package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.naming.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private Connection con = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	public Connection getMyConnection() throws SQLException, NamingException {

		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ibm");
		return ds.getConnection();
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		int item = 0;

		String uName = request.getParameter("uName").trim();
		String password = request.getParameter("password");
		String userType = request.getParameter("userType").trim();
		try {
			con = getMyConnection();

			PreparedStatement ps = con.prepareStatement(
					"select userName, password, userType from userDetail where userName=? AND password=? AND userType=? ");
			ps.setString(1, uName);
			ps.setString(2, password);
			ps.setString(3, userType);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				item++;
			}
			if (item > 0) {
				/*
				 * // session HttpSession session = request.getSession();
				 * 
				 * session.setAttribute("SES", request.getParameter("uName"));
				 */
				
				Cookie c1 = new Cookie("c1", uName);
				Cookie c2 = new Cookie("c2",password);
				
				response.addCookie(c1);
				response.addCookie(c2);
				
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/userpage.jsp");
				view.forward(request, response);
			} else {
				out.println("<font color='red'>user id/password is incorrect!</font><br/>");
				RequestDispatcher view = request.getRequestDispatcher("home.jsp");
				view.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
