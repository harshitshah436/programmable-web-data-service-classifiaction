package com.rit.pa4.view;

/**
 * MashuView is a simple POJO class to render mashup view details into mashup
 * controller and vice versa. It models view details into controller.
 * 
 * @author Harshit
 */
public class MashupView {
	private String tags;
	private String apis;
	private String updated;
	private String keyword;

	/*
	 * Getters and setters for all variables.
	 */

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getApis() {
		return apis;
	}

	public void setApis(String apis) {
		this.apis = apis;
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
