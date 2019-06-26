package com.example.springdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/main")
	public String showMessage() {
		return "main-page";
	}

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	/*
	 * @RequestMapping("/processForm") public String processFormVersion1() { return
	 * "helloworld"; }
	 */

	/*
	 * @RequestMapping("/processForm") public String
	 * processFormVersion2(HttpServletRequest request, Model theModel) { String
	 * tempName = request.getParameter("name").toUpperCase().trim();
	 * theModel.addAttribute("message", tempName); return "helloworld"; }
	 */
	
	@RequestMapping("/processForm")
	public String processFormVersion3(@RequestParam("name") String theName, Model theModel) {
		String temp = "Yo "+ theName.toUpperCase() + ", dude, welcome to spring MVC";
		theModel.addAttribute("message", temp);
		return "helloworld";
		
	}

}
