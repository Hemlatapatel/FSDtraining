package com.example.model;

public class RatingModel {

	private int id;
	private double rating;
	
	
	
	public RatingModel(int id, double rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
