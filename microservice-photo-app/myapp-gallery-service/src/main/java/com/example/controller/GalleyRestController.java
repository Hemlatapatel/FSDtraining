package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.GalleryModel;

@RestController
@RequestMapping("/")
public class GalleyRestController {

	@Autowired
    private RestTemplate restTemplate;
	private Environment env;
	

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: ";
	}
	
	@RequestMapping("/{id}")
	public GalleryModel getGallery(@PathVariable final int id) {
		
		
		GalleryModel gallery = new GalleryModel();
		gallery.setId(id);

		
r		List<Object> ratings = restTemplate.getForObject("http://rating-ws/ratings", List.class);
		gallery.setImages(images);
		gallery.setRatings(ratings);
	
		return gallery;
	}

	
}
