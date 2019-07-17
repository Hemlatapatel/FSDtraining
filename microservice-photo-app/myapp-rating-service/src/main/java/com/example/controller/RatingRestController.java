package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RatingModel;

@RestController
@RequestMapping("/")
public class RatingRestController {

	@RequestMapping("/ratings")
	public List< RatingModel> getRatings() {
		
		List<RatingModel> ratings =  Arrays.asList(new RatingModel(1,5.4),
				new RatingModel(2,3.5),new RatingModel(3,6.2));
				
		return ratings;
	}
}
