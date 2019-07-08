package com.example.springdemo.converter.demospringbootconverter.rest;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterRestController {
	
	
	@RequestMapping("/")
	public String convert() {
		return "home";
	}
	@RequestMapping("/{inr}")
	public String convert(@PathVariable double inr) {
		return "INR is: " + inr + " Equivalent dollar is : " + inr/68.66;
	}
}
