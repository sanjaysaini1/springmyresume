package com.springmyresume.resume;

import java.util.List;

import com.springmyresume.resume.education.Education;
import com.springmyresume.resume.education.Publications;
import com.springmyresume.resume.experience.Experience;
import com.springmyresume.resume.objective.Objective;
import com.springmyresume.resume.personeldetails.PersonalDetails;
import com.springmyresume.resume.references.References;
import com.springmyresume.resume.skills.Skills;

public interface ResumePlan {
	
	public void setId(String id);
	public void setObjective(Objective objective);
	public void setPersonalDetails(PersonalDetails personalDetails);
	public void setSkills(List<Skills> skills);
	public void setExperience(List<Experience> experience);
	public void setEducation(List<Education> education);
	public void setReferences(List<References> references);
	public void setPublications(List<Publications> publications);

	

}
