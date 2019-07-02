package com.example.springdemo;

import java.util.List;

public interface StudentService {
	public void addStudent(Student student);

	public List<Student> getAllStudent();

	public void editStudentById(Student student);
	
	public void deleteStudentById(int id);

}
