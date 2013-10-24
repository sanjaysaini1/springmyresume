package com.springmyresume.resume.references;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;

@Document
@Component

public class ReferencesImpl implements EmbeddedResumeObject,References,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5075651217967825796L;
	private String referenceName;
	private String referenceAddress;
	private String referenceContactNumber;
	
	/*@Idsuper();
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
	
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getReferenceAddress() {
		return referenceAddress;
	}
	public void setReferenceAddress(String referenceAddress) {
		this.referenceAddress = referenceAddress;
	}
	public String getReferenceContactNumber() {
		return referenceContactNumber;
	}
	public void setReferenceContactNumber(String referenceContactNumber) {
		this.referenceContactNumber = referenceContactNumber;
	}
	
	

}
