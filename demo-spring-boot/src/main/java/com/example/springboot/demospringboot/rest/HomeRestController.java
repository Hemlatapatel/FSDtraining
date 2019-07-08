package com.example.springboot.demospringboot.rest;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

	@Value("${coach.name}")
	private String coach;
	
	@Value("${team.name}")
	private String team;
	
	@RequestMapping("/")
	public String sayHello() {
		return "Welcome spring boot... current time is" + LocalTime.now();
				
	}
	
	@RequestMapping("/workout")
	public String workout() {
		return "Do meditation today...";
	}
	
	@RequestMapping("/fortune")
	public String fortune() {
		return "Today is your lucky day....";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "This is testing....";
	}
	
	@RequestMapping("/teamInfo")
	public String teamInfo() {
		return "Coach is : " + coach + " Team is : " + team;
	}
}
