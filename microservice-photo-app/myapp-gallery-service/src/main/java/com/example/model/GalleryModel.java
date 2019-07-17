package com.example.model;

import java.util.List;

public class GalleryModel {

	private int id;
	private List images;
	private List ratings;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getImages() {
		return images;
	}
	public void setImages(List images) {
		this.images = images;
	}
	public List getRatings() {
		return ratings;
	}
	public void setRatings(List ratings) {
		this.ratings = ratings;
	}
	
	
}
