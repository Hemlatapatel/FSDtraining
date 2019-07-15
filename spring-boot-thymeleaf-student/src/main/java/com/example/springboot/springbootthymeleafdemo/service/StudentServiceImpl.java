package com.example.springboot.springbootthymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.springbootthymeleafdemo.dao.StudentRepositoryDAO;
import com.example.springboot.springbootthymeleafdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepositoryDAO studentRepositoryDAO;
	
	@Autowired
	public StudentServiceImpl(StudentRepositoryDAO studentRepositoryDAO) {
		super();
		this.studentRepositoryDAO = studentRepositoryDAO;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepositoryDAO.findAll();
	}

	
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
        studentRepositoryDAO.save(student);
	}

	@Override
	public Optional<Student> findById(int id) {
		
		Optional<Student> employee = studentRepositoryDAO.findById(id);
		return employee;
	}
	
	@Override
	public void deleteById(int theId) {
		studentRepositoryDAO.deleteById(theId);
	}

	@Override
	public List<Student> searchByName(String theFirstName, String theLastName) {
		
		return studentRepositoryDAO.
				findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
						theFirstName, theLastName);	
	}

}
