package com.springmyresume.resume;


import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.education.Education;
import com.springmyresume.resume.education.Publications;
import com.springmyresume.resume.experience.Experience;
import com.springmyresume.resume.objective.Objective;
import com.springmyresume.resume.personeldetails.PersonalDetails;
import com.springmyresume.resume.references.References;
import com.springmyresume.resume.skills.Skills;


@Component("resume")
@Scope("request")
public class Resume implements ResumePlan,Serializable {

	private static final long serialVersionUID = -5332235643191283709L;
	
	
	@Id
	private String id;
	

	
	@DBRef
	private Objective objective;


	
	@DBRef
	private PersonalDetails personalDetails;
	
    
	private List<Skills> skills;
	
	
	private List<Experience> experience;
	
	
	
	private List<Education> education;
	
	
	
	private List<References> references;
	
	
	private List<Publications> publications;
	

	public Objective getObjective() {
		return objective;
	}
	
	
	
	public List<Publications> getPublications() {
		return publications;
	}

	public void setPublications(List<Publications> publications) {
		this.publications = publications;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}


	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public List<Education> getEducation() {
		return education;
	}

	public List<References> getReferences() {
		return references;
	}

	public void setObjective(Objective objective) {
		this.objective=objective;

	}
	
	public void setSkills(List<Skills> skills) {
		
		this.skills=skills;

	}

	public void setExperience(List<Experience> experience) {
		this.experience=experience;

	}

	public void setEducation(List<Education> education) {
		this.education=education;

	}

	public void setReferences(List<References> references) {
		this.references=references;

	}

	  
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "Resume [id=" + id + ", objective=" + objective
				+ ", personalDetails=" + personalDetails + ", skills=" + skills
				+ ", experience=" + experience + ", education=" + education
				+ ", references=" + references + ", publications="
				+ publications + "]";
	}
	

}
