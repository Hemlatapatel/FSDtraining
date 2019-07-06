package com.serializable.student;

import java.io.Serializable;

public class Course  {
	
	private String courseTitle;
	private String coursePrice;
	public Course() {
		super();
	}
	public Course(String courseTitle, String coursePrice) {
		super();
		this.courseTitle = courseTitle;
		this.coursePrice = coursePrice;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}
	@Override
	public String toString() {
		return "Course [courseTitle=" + courseTitle + ", coursePrice=" + coursePrice + "]";
	}
	
	
}
