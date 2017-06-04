package com.rit.pa4.view;

/**
 * APIView is a simple POJO class to render api view details into APIController
 * and vice versa. It models view details into controller.
 * 
 * @author Harshit
 */
public class APIView {
	private String rating;
	private String tags;
	private String category;
	private String protocols;
	private String updated;
	private String keyword;

	/*
	 * Getters and setters for all variables.
	 */

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProtocols() {
		return protocols;
	}

	public void setProtocols(String protocols) {
		this.protocols = protocols;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
