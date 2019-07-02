package com.example.springdemo;

import java.util.List;

public class StudentserviceImpl implements StudentService  {

	private StudentDAO dao;
	
	
	public StudentserviceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentserviceImpl(StudentDAO dao) {
		super();
		this.dao = dao;
	}
	
	

	public StudentDAO getDao() {
		return dao;
	}

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		dao.addStudent(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.getAllStudent();
	}

	@Override
	public void editStudentById(Student student) {
		// TODO Auto-generated method stub
		dao.editStudentById(student);
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		dao.deleteStudentById(id);
	}

}

