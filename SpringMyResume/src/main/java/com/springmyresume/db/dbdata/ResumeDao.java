package com.springmyresume.db.dbdata;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmyresume.resume.EmbeddedResumeObject;
import com.springmyresume.resume.Resume;
import com.springmyresume.resume.education.Education;
import com.springmyresume.resume.education.Publications;
import com.springmyresume.resume.experience.Experience;
import com.springmyresume.resume.objective.Objective;
import com.springmyresume.resume.personeldetails.PersonalDetails;
import com.springmyresume.resume.references.References;
import com.springmyresume.resume.skills.Skills;


@Repository
public interface ResumeDao {
	
	
	public Resume getResume(Object object);
	public boolean setResume(Resume resume); 
	
	public Objective getObjective(Object object);
	public boolean setObjective(Objective objective);
	
	public PersonalDetails getPersonalDetails(Object object);
	//public boolean setPersonalDetails(PersonalDetails personalDetails,String rid);
	
	public List<Skills> getSkills(Object object);
	//public boolean setSkills(Skills skills,String rid);
	
	public List<Experience> getExperience(Object object);
	//public boolean setExperience(Experience experience,String rid);
	
	public List<Education> getEducation(Object object);
	//public boolean setEducation(Education education,String rid);
	
	public List<Publications> getPublications(Object object);
	//public boolean setPublications(Publications publication,String rid);
	
	public List<References> getReferences(Object object);
	//public boolean setReferences(References  references,String rid);
	public boolean setEmbeddedResumeObject(EmbeddedResumeObject object,String id);
	public org.springframework.data.mongodb.core.MongoOperations getMongoOperations();

	public void setMongoOperations(
			org.springframework.data.mongodb.core.MongoOperations mongoOperations);
}
