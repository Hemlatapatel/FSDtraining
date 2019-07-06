

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		int idValue = Integer.parseInt(id);
	    String name = request.getParameter("name");
	    String contact = request.getParameter("contact"); 
	    int contactValue = Integer.parseInt(contact);
	    String email = request.getParameter("email");
	    String address = request.getParameter("address");
	    
	    Student s = new Student();
	    
	    s.setId(id);

	    s.setName(name);
	    s.setContact(contact);
	    s.setEmail(email);
	    s.setAddress(address);
	    
	    int status = StudentDAO.insert(s);
	    
	    if(status>0) {
	    	out.print("<p>Record inserted successfully</p>");
	    } else {
	    	out.print("<p>Record not inserted</p>");
	    }
	out.close();
	}
	
}
