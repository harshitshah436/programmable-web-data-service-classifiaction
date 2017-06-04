package com.rit.pa4.model;

import org.springframework.data.annotation.Id;

/**
 * API is a simple POJO class to represent the fields of API collection of
 * database into a Java Object. API models a data structure for the API
 * collection of the database.
 * 
 * @author Harshit
 */
public class API {
	@Id
	private String _id;
	private String id;
	private String title;
	private String summary;
	private double rating;
	private String name;
	private String label;
	private String author;
	private String description;
	private String type;
	private String downloads;
	private String useCount;
	private String sampleUrl;
	private String downloadUrl;
	private String dateModified;
	private String remoteFeed;
	private String numComments;
	private String commentsUrl;
	private String tags;
	private String category;
	private String protocols;
	private String serviceEndPoint;
	private String version;
	private String wsdl;
	private String dataFormats;
	private String apiGroups;
	private String example;
	private String clientInstall;
	private String authentication;
	private String ssl;
	private String readonly;
	private String vendorApiKits;
	private String communityApiKits;
	private String blog;
	private String forum;
	private String support;
	private String accountReq;
	private String commercial;
	private String provider;
	private String managedBy;
	private String nonCommercial;
	private String dataLicensing;
	private String fees;
	private String limits;
	private String terms;
	private String company;
	private String updated;

	/**
	 * Override default constructor.
	 */
	public API() {
	}

	/**
	 * Construct API object using the given field values.
	 */
	public API(String id, String title, String summary, double rating, String name, String label, String author,
			String description, String type, String downloads, String useCount, String sampleUrl, String downloadUrl,
			String dateModified, String remoteFeed, String numComments, String commentsUrl, String tags,
			String category, String protocols, String serviceEndPoint, String version, String wsdl, String dataFormats,
			String apiGroups, String example, String clientInstall, String authentication, String ssl, String readonly,
			String vendorApiKits, String communityApiKits, String blog, String forum, String support, String accountReq,
			String commercial, String provider, String managedBy, String nonCommercial, String dataLicensing,
			String fees, String limits, String terms, String company, String updated) {
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
		this.downloadUrl = downloadUrl;
		this.dateModified = dateModified;
		this.remoteFeed = remoteFeed;
		this.numComments = numComments;
		this.commentsUrl = commentsUrl;
		this.tags = tags;
		this.category = category;
		this.protocols = protocols;
		this.serviceEndPoint = serviceEndPoint;
		this.version = version;
		this.wsdl = wsdl;
		this.dataFormats = dataFormats;
		this.apiGroups = apiGroups;
		this.example = example;
		this.clientInstall = clientInstall;
		this.authentication = authentication;
		this.ssl = ssl;
		this.readonly = readonly;
		this.vendorApiKits = vendorApiKits;
		this.communityApiKits = communityApiKits;
		this.blog = blog;
		this.forum = forum;
		this.support = support;
		this.accountReq = accountReq;
		this.commercial = commercial;
		this.provider = provider;
		this.managedBy = managedBy;
		this.nonCommercial = nonCommercial;
		this.dataLicensing = dataLicensing;
		this.fees = fees;
		this.limits = limits;
		this.terms = terms;
		this.company = company;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
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

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	public String getRemoteFeed() {
		return remoteFeed;
	}

	public void setRemoteFeed(String remoteFeed) {
		this.remoteFeed = remoteFeed;
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

	public String getServiceEndPoint() {
		return serviceEndPoint;
	}

	public void setServiceEndPoint(String serviceEndPoint) {
		this.serviceEndPoint = serviceEndPoint;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getWsdl() {
		return wsdl;
	}

	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}

	public String getDataFormats() {
		return dataFormats;
	}

	public void setDataFormats(String dataFormats) {
		this.dataFormats = dataFormats;
	}

	public String getApiGroups() {
		return apiGroups;
	}

	public void setApiGroups(String apiGroups) {
		this.apiGroups = apiGroups;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getClientInstall() {
		return clientInstall;
	}

	public void setClientInstall(String clientInstall) {
		this.clientInstall = clientInstall;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getSsl() {
		return ssl;
	}

	public void setSsl(String ssl) {
		this.ssl = ssl;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getVendorApiKits() {
		return vendorApiKits;
	}

	public void setVendorApiKits(String vendorApiKits) {
		this.vendorApiKits = vendorApiKits;
	}

	public String getCommunityApiKits() {
		return communityApiKits;
	}

	public void setCommunityApiKits(String communityApiKits) {
		this.communityApiKits = communityApiKits;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getForum() {
		return forum;
	}

	public void setForum(String forum) {
		this.forum = forum;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public String getAccountReq() {
		return accountReq;
	}

	public void setAccountReq(String accountReq) {
		this.accountReq = accountReq;
	}

	public String getCommercial() {
		return commercial;
	}

	public void setCommercial(String commercial) {
		this.commercial = commercial;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getManagedBy() {
		return managedBy;
	}

	public void setManagedBy(String managedBy) {
		this.managedBy = managedBy;
	}

	public String getNonCommercial() {
		return nonCommercial;
	}

	public void setNonCommercial(String nonCommercial) {
		this.nonCommercial = nonCommercial;
	}

	public String getDataLicensing() {
		return dataLicensing;
	}

	public void setDataLicensing(String dataLicensing) {
		this.dataLicensing = dataLicensing;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getLimits() {
		return limits;
	}

	public void setLimits(String limits) {
		this.limits = limits;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "API [id=" + id + ", title=" + title + ", summary=" + summary + ", rating=" + rating + ", name=" + name
				+ ", label=" + label + ", author=" + author + ", description=" + description + ", type=" + type
				+ ", downloads=" + downloads + ", useCount=" + useCount + ", sampleUrl=" + sampleUrl + ", downloadUrl="
				+ downloadUrl + ", dateModified=" + dateModified + ", remoteFeed=" + remoteFeed + ", numComments="
				+ numComments + ", commentsUrl=" + commentsUrl + ", tags=" + tags + ", category=" + category
				+ ", protocols=" + protocols + ", serviceEndPoint=" + serviceEndPoint + ", version=" + version
				+ ", wsdl=" + wsdl + ", dataFormats=" + dataFormats + ", apiGroups=" + apiGroups + ", example="
				+ example + ", clientInstall=" + clientInstall + ", authentication=" + authentication + ", ssl=" + ssl
				+ ", readonly=" + readonly + ", vendorApiKits=" + vendorApiKits + ", communityApiKits="
				+ communityApiKits + ", blog=" + blog + ", forum=" + forum + ", support=" + support + ", accountReq="
				+ accountReq + ", commercial=" + commercial + ", provider=" + provider + ", managedBy=" + managedBy
				+ ", nonCommercial=" + nonCommercial + ", dataLicensing=" + dataLicensing + ", fees=" + fees
				+ ", limits=" + limits + ", terms=" + terms + ", company=" + company + ", updated=" + updated + "]";
	}

}
