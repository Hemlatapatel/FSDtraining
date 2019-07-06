import java.util.*;
import java.io.PrintWriter;
import java.sql.*;

public class StudentDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from student_detail");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int insert(Student s) {
		
		int status = 0;
		try {
			Connection con = StudentDAO.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into student_detail(id, name, contact, email, address) values(?,?,?,?,?)");
					
			ps.setString(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getContact());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getAddress());
			
			status= ps.executeUpdate();
		} catch(Exception e) {
			
		}
	
		return status;
	}
}
