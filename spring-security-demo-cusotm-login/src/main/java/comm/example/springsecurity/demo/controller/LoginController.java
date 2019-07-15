package comm.example.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/systems")
	public String goToSystems() {
		return "systems";
	}
	
	@GetMapping("/leaders")
	public String goToLeaders() {
		return "leaders";
	}
	
	
}
