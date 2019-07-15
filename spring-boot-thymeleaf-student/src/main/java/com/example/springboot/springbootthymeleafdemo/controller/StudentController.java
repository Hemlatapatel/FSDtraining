package com.example.springboot.springbootthymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.springbootthymeleafdemo.entity.Student;
import com.example.springboot.springbootthymeleafdemo.service.StudentService;

@Controller
@RequestMapping("/students")

public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@RequestMapping("/list")
	public String list(Model theModel) {

		theModel.addAttribute("studentList", studentService.findAll());
		return "student-list";
	}

	@RequestMapping("/add")
	public String add(@RequestParam("id") int id, Model theModel) {

		if (id > 0) {
			System.out.println("Id is : " + id);

			Optional<Student> std = studentService.findById(id);

			theModel.addAttribute("student", std);
		} else {

			Student student = new Student();
			theModel.addAttribute("student", student);
		}
		return "add-student";
	}

	@RequestMapping("/save")
	public String addForm(@RequestParam("id") int id, @ModelAttribute("student") Student student,

			BindingResult bindingResult, Model theModel) {

//		if (bindingResult.hasErrors()) {
//			return "add-student";
//		}

		studentService.save(student);
		return "redirect:/students/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {

		// delete the employee
		studentService.deleteById(theId);

		// redirect to /employees/list
		return "redirect:/students/list";

	}

	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName, @RequestParam("lastName") String theLastName,
			Model theModel) {

		// check names, if both are empty then just give list of all employees

		if (theFirstName.trim().isEmpty() && theLastName.trim().isEmpty()) {
			return "redirect:/students/list";
		} else {
			// else, search by first name and last name
			List<Student> studentList = studentService.searchByName(theFirstName, theLastName);

			// add to the spring model
			theModel.addAttribute("studentList", studentList);

			// send to list-students
			return "student-list";
		}

	}
}
