package com.springmyresume.resume.education;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;
import com.springmyresume.resume.utility.Utility;

@Document
@Component("education")

public class EducationImpl implements EmbeddedResumeObject,Education,Serializable {
	
	
	
	private static final long serialVersionUID = 223469317472239344L;
	/*@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
	private String degree;
	private String institution;
	private String location;
	private double marksObtained;
	private double maximumMarks;
	private String remarks;
	private String yearofJoining;
		private String yearofPassing;
	
	public EducationImpl(String degree, String institution, String location,
			double marksObtained, double maximumMarks, String remarks,String yearofJoining,String yearofPassing) {
		this.degree = degree;
		this.institution = institution;
		this.location = location;
		this.marksObtained = marksObtained;
		this.maximumMarks = maximumMarks;
		this.remarks = remarks;
		this.yearofPassing=yearofPassing;
		this.yearofJoining=yearofJoining;
	}
	
	public EducationImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getYearofJoining() {
		return yearofJoining;
	}

	public void setYearofJoining(String yearofJoining) {
		try {
			Date d= new SimpleDateFormat( "EEE MMM dd HH:mm:ss Z yyyy").parse(yearofJoining);
			this.yearofJoining= new SimpleDateFormat("dd/MM/YYYY").format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//Utility.p("Date conversion failed");
			this.yearofJoining = yearofJoining;
		}
		//Utility.p(this.yearofJoining);
		//this.yearofJoining = yearofJoining;
	}


	
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}
	public double getMaximumMarks() {
		return maximumMarks;
	}
	public void setMaximumMarks(double maximumMarks) {
		this.maximumMarks = maximumMarks;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "EducationImpl [degree=" + degree + ", institution="
				+ institution + ", location=" + location + ", marksObtained="
				+ marksObtained + ", maximumMarks=" + maximumMarks
				+ ", remarks=" + remarks + "]";
	}

	public String getYearofPassing() {
		return yearofPassing;
	}

	public void setYearofPassing(String yearofPassing) {
		try {
			Date d= new SimpleDateFormat( "EEE MMM dd HH:mm:ss Z yyyy").parse(yearofPassing);
			this.yearofPassing= new SimpleDateFormat("dd/MM/YYYY").format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//Utility.p("Date conversion failed");
			this.yearofPassing = yearofPassing;
		}
		
		//this.yearofPassing = yearofPassing;
	}
	
	
	

}
