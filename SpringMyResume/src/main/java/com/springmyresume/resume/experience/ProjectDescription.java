package com.springmyresume.resume.experience;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component("projectDescription")

public class ProjectDescription implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2496006766825195705L;
	private String projectDescription;
	/*@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
*/
	
	public ProjectDescription() {
		// TODO Auto-generated constructor stub
	}

	public ProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
		
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Override
	public String toString() {
		return "ProjectDescription [ projectDescription=" + projectDescription
				+ "]";
	}

	

}
