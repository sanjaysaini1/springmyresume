package com.springmyresume.resume.experience;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;

@Document
@Component("experience")

public class ExperienceImpl implements EmbeddedResumeObject,Experience,Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3369426146304913264L;
	private String company;
	private String startDate;
	private String endDate;
	private List<Project> projectList;
	private String remarks;
	/*@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
	
	
	public ExperienceImpl() {
		
	}



	public ExperienceImpl(String company, String startDate, String endDate,
			List<Project> projectList, String remarks) {
		this.company = company;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectList = projectList;
		this.remarks = remarks;
	}	
	
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String  startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String  endDate) {
		this.endDate = endDate;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	@Override
	public String toString() {
		return "ExperienceImpl [company=" + company + ", startDate="
				+ startDate + ", endDate=" + endDate + ", projectList="
				+ projectList + ", remarks=" + remarks + "]";
	}



	
	
	
	
	

}
