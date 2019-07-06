

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class demo
 */
@WebServlet("/demo")
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public demo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		 try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
		    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		    	Statement stmt = con.createStatement();
		    	ResultSet rs = stmt.executeQuery("Select * from student_detail");
		    	while(rs.next()) {
		    		out.println(rs.getInt(1) + " " + rs.getString(2));
		    	}
		    	
		    	con.close();	    	
		 } catch(Exception e) {
			 System.out.println(e);
		 }
	}
}
