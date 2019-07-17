package com.example.shared;

import java.io.Serializable;

public class ProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681693867931538393L;

	private String name;
	private String description;
	private String pId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
}
