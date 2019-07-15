package com.example.springboot.springbootthymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model theModel) {
		
		theModel.addAttribute("theDate", new Date());
		return "hello-world";
	}
}
