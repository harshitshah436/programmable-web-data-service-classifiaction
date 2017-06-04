package com.rit.pa4.model;

import org.springframework.data.annotation.Id;

/**
 * Mashup is a simple POJO class to represent the fields of Mashup collection of
 * database into a Java Object. Mashup models a data structure for the Mashup
 * collection of the database.
 * 
 * @author Harshit
 */
public class Mashup {

	@Id
	private String _id;
	private String id;
	private String title;
	private String summary;
	private String rating;
	private String name;
	private String label;
	private String author;
	private String description;
	private String type;
	private String downloads;
	private String useCount;
	private String sampleUrl;
	private String dateModified;
	private String numComments;
	private String commentsUrl;
	private String tags;
	private String apis;
	private String updated;

	/**
	 * Override default constructor.
	 */
	public Mashup() {
	}

	/**
	 * Construct Mashup object using the given field values.
	 */
	public Mashup(String id, String title, String summary, String rating, String name, String label, String author,
			String description, String type, String downloads, String useCount, String sampleUrl, String dateModified,
			String numComments, String commentsUrl, String tags, String apis, String updated) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.rating = rating;
		this.name = name;
		this.label = label;
		this.author = author;
		this.description = description;
		this.type = type;
		this.downloads = downloads;
		this.useCount = useCount;
		this.sampleUrl = sampleUrl;
		this.dateModified = dateModified;
		this.numComments = numComments;
		this.commentsUrl = commentsUrl;
		this.tags = tags;
		this.apis = apis;
		this.updated = updated;
	}

	/*
	 * Getters and setters for all variables.
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDownloads() {
		return downloads;
	}

	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}

	public String getUseCount() {
		return useCount;
	}

	public void setUseCount(String useCount) {
		this.useCount = useCount;
	}

	public String getSampleUrl() {
		return sampleUrl;
	}

	public void setSampleUrl(String sampleUrl) {
		this.sampleUrl = sampleUrl;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public String getNumComments() {
		return numComments;
	}

	public void setNumComments(String numComments) {
		this.numComments = numComments;
	}

	public String getCommentsUrl() {
		return commentsUrl;
	}

	public void setCommentsUrl(String commentsUrl) {
		this.commentsUrl = commentsUrl;
	}

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

	@Override
	public String toString() {
		return "Mashup [id=" + id + ", title=" + title + ", summary=" + summary + ", rating=" + rating + ", name="
				+ name + ", label=" + label + ", author=" + author + ", description=" + description + ", type=" + type
				+ ", downloads=" + downloads + ", useCount=" + useCount + ", sampleUrl=" + sampleUrl + ", dateModified="
				+ dateModified + ", numComments=" + numComments + ", commentsUrl=" + commentsUrl + ", tags=" + tags
				+ ", apis=" + apis + ", updated=" + updated + "]";
	}

}
