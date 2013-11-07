package com.springmyresume.resume.personeldetails;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;
import com.springmyresume.resume.utility.Utility;


@Component
@Scope("request")
public class PersonalDetailsImpl implements EmbeddedResumeObject,Serializable,PersonalDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9018240338842835132L;
	
	private String name;
	private String dateOfBirth;
	private String address;
	private String emailId;
	private String contactNumber;
	private String languagesKnown;
	private String interests;
	

	@PersistenceConstructor
	public PersonalDetailsImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		try {
			Date d= new SimpleDateFormat( "EEE MMM dd HH:mm:ss Z yyyy").parse(dateOfBirth);
			this.dateOfBirth= new SimpleDateFormat("dd/MM/YYYY").format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Utility.p("Date conversion failed");
			this.dateOfBirth = dateOfBirth;
		}
		Utility.p(this.dateOfBirth);
		
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getLanguagesKnown() {
		return languagesKnown;
	}
	
	public void setLanguagesKnown(String languagesKnown) {
		this.languagesKnown = languagesKnown;
	}
	
	public String getInterests() {
		return interests;
	}
	
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "PersonalDetailsImpl [name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", languagesKnown="
				+ languagesKnown + ", interests=" + interests + "]";
	}
	
	
	
}
