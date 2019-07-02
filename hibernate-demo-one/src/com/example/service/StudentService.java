package com.example.service;

import java.util.List;

import com.example.entity.Student;

public interface StudentService {
	public void createStudent(Student student);

	public List<Student> getAllStudent();

	public Student getStudentById(int id);

	public List<Student> getStudentByName(String fName);

	public void deleteById(int id);

	public List<Student> getStudentByLastName(String lName);

	public void updateById(int id);

}
