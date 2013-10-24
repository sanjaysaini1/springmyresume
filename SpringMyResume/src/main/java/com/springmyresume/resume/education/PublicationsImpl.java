package com.springmyresume.resume.education;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;

@Document
@Component
@Scope("request")
public class PublicationsImpl implements EmbeddedResumeObject,Publications,Serializable{

	
	private static final long serialVersionUID = -6077685973347478040L;
	private String paperName;
	private String conference;
	private String journal;
	private int year;
	private String paperDetails;
	
	/*@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	*/
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPaperDetails() {
		return paperDetails;
	}
	public void setPaperDetails(String paperDetails) {
		this.paperDetails = paperDetails;
	}
	@Override
	public String toString() {
		return "PublicationsImpl [paperName=" + paperName + ", conference="
				+ conference + ", journal=" + journal + ", year=" + year
				+ ", paperDetails=" + paperDetails + "]";
	}
	
	
}
