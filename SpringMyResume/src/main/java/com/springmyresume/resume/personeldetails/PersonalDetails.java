package com.springmyresume.resume.personeldetails;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("request")
public interface PersonalDetails {

	
	public String getName();
	public void setName(String name);
	
	public String getDateOfBirth();
	
	public void setDateOfBirth(String dateOfBirth);
	
	public String getAddress();
	
	public void setAddress(String address);
	
	public String getContactNumber();
	
	public void setContactNumber(String contactNumber);
	
	public String getLanguagesKnown();
	
	public void setLanguagesKnown(String languagesKnown);
	
	public String getInterests();
	
	public void setInterests(String interests);
	public String getEmailId();
	public void setEmailId(String emailId);
}
