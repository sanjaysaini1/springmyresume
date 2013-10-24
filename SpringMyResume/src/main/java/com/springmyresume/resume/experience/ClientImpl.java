package com.springmyresume.resume.experience;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;

@Document
@Component

public class ClientImpl implements EmbeddedResumeObject,Client,Serializable {


	
	private static final long serialVersionUID = -8102785965125938506L;
	private String clientName;
	private String clientLocation;
	/*@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	*/
	
	public ClientImpl() {
		// TODO Auto-generated constructor stub
	}

	public ClientImpl(String clientName, String clientLocation) {
		this.clientName = clientName;
		this.clientLocation = clientLocation;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientLocation() {
		return clientLocation;
	}
	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	@Override
	public String toString() {
		return "Client [ clientName=" + clientName + " , clientLocation="
				+ clientLocation + "]";
	}

	
}
