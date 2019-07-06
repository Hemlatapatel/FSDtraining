import java.sql.DriverManager;
import java.sql.*;

public class JDBCConnection {
	public static void main(String args[]) {
		System.out.println("Hello");
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	    	Statement stmt = con.createStatement();
	    	ResultSet rs = stmt.executeQuery("Select * from student_detail");
	    	while(rs.next()) {
	    		System.out.println(rs.getInt(1));
	    	}
	    	
	    	con.close();	    	
	 } catch(Exception e) {
		 System.out.println(e);
	 }
	}
}
