package com.springmyresume.resume.experience;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;
import com.springmyresume.resume.skills.Skills;

@Document
@Component
@Scope("request")
public class ProjectImpl implements EmbeddedResumeObject,Project,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6793295053165926479L;
	private String projectName;
	@Autowired
	private ProjectDescription projectDescription;
	@Autowired
	private Client client;
	
	private List<Skills> skillsUsed;

	/*@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	*/
	
	public ProjectImpl() {
		// TODO Auto-generated constructor stub
		this.projectDescription=new ProjectDescription();
		this.client=new ClientImpl();
	}

	public ProjectImpl(String projectName, ProjectDescription projectDescription,
			Client client, List<Skills> skillsUsed) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.client = client;
		this.skillsUsed = skillsUsed;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ProjectDescription getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(ProjectDescription projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Skills> getSkillsUsed() {
		return skillsUsed;
	}

	public void setSkillsUsed(List<Skills> skillsUsed) {
		this.skillsUsed = skillsUsed;
	}

	@Override
	public String toString() {
		return "Project [\n projectName=" + projectName
				+ " \n projectDescription=" + projectDescription + " \n client="
				+ client + " \n skillsUsed=" + skillsUsed + "\n]";
	}

	
}
