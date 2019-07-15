package com.example.springboot.springbootthymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.springbootthymeleafdemo.entity.Student;

public interface StudentRepositoryDAO extends JpaRepository<Student, Integer> {

	
	// that's it ... no need to write any code LOL!
	
		// add a method to sort by last name
		public List<Student> findAllByOrderByLastNameAsc();

		// add a method to search by first name and last name
		public List<Student> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
										String theFirstName, String theLastName);
}
