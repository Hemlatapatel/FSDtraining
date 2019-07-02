package com.example.springdemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jTemplate;
	
	
	
	public StudentDAOImpl() {}

	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}
		


	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}



	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub

		String[] arr = student.getOperatingSystem();
		String str="";
		for(String s: arr) {
			str += s+ " , ";
		}
		jTemplate.update("insert into student(firstName, lastName, country, favoriteLanguage, operatingSystem) values(?,?,?,?,?)",
				student.getFirstName(), student.getLastName(), student.getCountry(), student.getFavoriteLanguage(),
				str);
		
	}
	
	@Override
	public List<Student> getAllStudent() {
		return jTemplate.query("select * from student", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setFirstName(rs.getString(2));
				student.setLastName(rs.getString(3));
				student.setCountry(rs.getString(4));
				student.setFavoriteLanguage(rs.getString(5));
				student.setOperating(rs.getString(6));
				return student;
			}
			
		});
	}

	@Override
	public void editStudentById(Student student) {
		// TODO Auto-generated method stub
		System.out.println("id==========" + student.getId());
		String[] arr = student.getOperatingSystem();
		String str="";
		for(String s: arr) {
			str += s+ " , ";
		}
		jTemplate.update("update student set firstName=?, lastName=?,country=?, favoriteLanguage=?, operatingSystem=?"
				+ "where id=?", student.getFirstName(), student.getLastName(), student.getCountry(),
				student.getFavoriteLanguage(), str, student.getId());
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		
		jTemplate.update("delete from student where id=?", id);
	}


}