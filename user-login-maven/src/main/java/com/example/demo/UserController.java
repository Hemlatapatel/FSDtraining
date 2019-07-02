package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl service;

	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user) {

		return "login-form";
	}

	@RequestMapping("/checkUser")
	public String checkUser(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, Model theModel) {

		if (bindingResult.hasErrors()) {
			return "login-form";
		} else {
			User u = service.checkUser(user);
			if (u != null) {
				theModel.addAttribute("user", user.getUserName());
				return "process-form";
			} else {
				theModel.addAttribute("error", "User not found");
				return "login-form";
			}
		}
	}
}