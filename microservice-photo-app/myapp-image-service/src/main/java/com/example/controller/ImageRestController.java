package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ImageModel;

@RestController
@RequestMapping("/")
public class ImageRestController {

//	List<ImageModel> images = null;
//
//	@PostConstruct
//	public void init() {
//        images = new ArrayList<ImageModel>();
//		images.add(new ImageModel(1, "test", "http://google.com"));
//		images.add(new ImageModel(2, "test2", "http://google.com"));
//		images.add(new ImageModel(1, "test3", "http://google.com"));
//
//	}
//	
//	@GetMapping("/images") 
//	public List<ImageModel> getImages() {
//		return images;
//	}

	@RequestMapping("/images")
	public List<ImageModel> getImages() {
		List<ImageModel> images = Arrays.asList(
				new ImageModel(1, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
				new ImageModel(2, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"), 
				new ImageModel(3,
						"The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
		return images;
	}
}