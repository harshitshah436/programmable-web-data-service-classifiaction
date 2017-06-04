package com.rit.pa4.view;

/**
 * MashuClassifierView is a simple POJO class to render mashup_classifier view
 * details into mashup controller and vice versa. It models view details into
 * controller.
 * 
 * @author Harshit
 */
public class MashupClassifierView {
	private String downloads;
	private String useCounts;
	private String numComments;
	private String updatedYear;

	/*
	 * Getters and setters for all variables.
	 */
	public String getDownloads() {
		return downloads;
	}

	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}

	public String getUseCounts() {
		return useCounts;
	}

	public void setUseCounts(String useCounts) {
		this.useCounts = useCounts;
	}

	public String getNumComments() {
		return numComments;
	}

	public void setNumComments(String numComments) {
		this.numComments = numComments;
	}

	public String getUpdatedYear() {
		return updatedYear;
	}

	public void setUpdatedYear(String updatedYear) {
		this.updatedYear = updatedYear;
	}
}
