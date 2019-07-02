package com.example.dao;

import java.util.List;

import com.example.entity.Student;

public interface StudentDAO {

	public void createStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public List<Student> getStudentByName(String fName);
	
	public List<Student> getStudentByLastName(String lName);
	public void deleteById(int id);
	
	public void updateById(int id);
}
