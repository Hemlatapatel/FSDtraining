package com.example.springboot.springbootthymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import com.example.springboot.springbootthymeleafdemo.entity.Student;

public interface StudentService {

	List<Student> findAll();
	
	void save(Student student);
	
	Optional<Student> findById(int id);

	void deleteById(int theId);

	List<Student> searchByName(String theFirstName, String theLastName);
	
	
}
