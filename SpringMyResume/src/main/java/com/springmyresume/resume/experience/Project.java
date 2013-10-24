package com.springmyresume.resume.experience;


import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.skills.Skills;

@Document
@Component
@Scope("request")
public interface Project {

	public String getProjectName() ;

	public void setProjectName(String projectName) ;

	public ProjectDescription getProjectDescription() ;
	public void setProjectDescription(ProjectDescription projectDescription) ;
	public Client getClient() ;
	public void setClient(Client client) ;
	public List<Skills> getSkillsUsed() ;
	public void setSkillsUsed(List<Skills> skillsUsed) ;
	public String toString() ;
	/*public String getId();
	public void setId(String id) ;*/
}
