package com.example.service;

import java.util.List;

import com.example.dao.StudentDAO;
import com.example.dao.StudentDaoImpl;
import com.example.entity.Student;

public class StudentserviceImpl implements StudentDAO {

	private StudentDAO dao;

	public StudentserviceImpl() {
		super();

		dao = new StudentDaoImpl();
	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		dao.createStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return dao.getStudentById(id);
	}

	@Override
	public List<Student> getStudentByName(String fName) {
		// TODO Auto-generated method stub
		return dao.getStudentByName(fName);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Student> getStudentByLastName(String lName) {
		// TODO Auto-generated method stub
		return dao.getStudentByLastName(lName);
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		dao.updateById(id);

	}
}
