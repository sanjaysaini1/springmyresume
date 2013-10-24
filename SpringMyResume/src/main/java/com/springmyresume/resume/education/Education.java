package com.springmyresume.resume.education;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component("education")

public interface Education {

	
	public String getDegree() ;
	public void setDegree(String degree) ;
	public String getInstitution() ;
	public void setInstitution(String institution) ;
	public String getLocation(); 
	public void setLocation(String location) ;
	public double getMarksObtained() ;
	public void setMarksObtained(double marksObtained) ;
	public double getMaximumMarks() ;
	public void setMaximumMarks(double maximumMarks) ;
	public String getRemarks() ;
	public void setRemarks(String remarks) ;
	public void setYearofPassing(String yearofPassing);
	public String getYearofPassing();
	
	public void setYearofJoining(String yearofJoining);
	public String getYearofJoining();
	
/*	public String getId();
	public void setId(String id) ;*/
}

