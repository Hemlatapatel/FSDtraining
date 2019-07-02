package com.example.springdemo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentserviceImpl service;

	@RequestMapping("/studentForm")
	public String studentForm(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "student-form";
	}

	/*
	 * @RequestMapping("/processForm") public String
	 * processForm(@ModelAttribute("student") Student student, Model theModel){
	 * 
	 * theModel.addAttribute("student", student); return "process-form"; }
	 */
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("in binding");
			return "student-form";
		} else {

			service.addStudent(student);
			return "redirect:/student/displayAll";

		}
//		theModel.addAttribute("student", student);
	}

	@RequestMapping("/displayAll")
	public String getAllStudent(Model theModel) {
		List<Student> list = service.getAllStudent();

		theModel.addAttribute("studentList", list);
		return "students";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable int id, @ModelAttribute("student") Student student, Model theModel) {
		theModel.addAttribute("id", id);
		return "edit-form";
	}

	@RequestMapping("/editedForm")
	public String editStudentById(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("in binding");
			return "edit-form";
		} else {

			service.editStudentById(student);
			return "redirect:/student/displayAll";
		}
	}

	@RequestMapping("/delete/{id}")
	public String deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);

		return "redirect:/student/displayAll";
	}
}
