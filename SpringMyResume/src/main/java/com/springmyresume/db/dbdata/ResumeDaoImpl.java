package com.springmyresume.db.dbdata;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
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
@Component("resumeDao")

public class ResumeDaoImpl implements ResumeDao {

 
 private org.springframework.data.mongodb.core.MongoOperations mongoOperations;
	  

	public org.springframework.data.mongodb.core.MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	public void setMongoOperations(
			org.springframework.data.mongodb.core.MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public Resume getResume(Object object) {
	//	System.out.println("++++++++++++++++++\nRetrieving Resume\n++++++++++++++++++");
		String key=(String)object;
		System.out.println("++++++++++++++++++\n"+key+"\n++++++++++++++++++");
		 Query query = new Query(Criteria.where("id").is(key));
		 Resume resume=(Resume) mongoOperations.findOne(query,Resume.class);
		return resume;
	}

	public boolean setResume(Resume resume) {
	//  System.out.println("Resume\n++++++++++++++++++++++++++++++\n"+resume);
		try{
	  mongoOperations.save(resume);
		}catch(Exception e)
		{
			System.out.println("Failure: "+e.toString());
			return false;
		}
		return true;

	}

	public String uncapitalize(String input)
	{
		 if (input.length() <= 1) {
		        input = input.toLowerCase();
		    } else {
		        input = input.substring(0, 1).toLowerCase() + input.substring(1);
		       
		    }
		 return input;
	}
	public boolean setEmbeddedResumeObject(EmbeddedResumeObject object,String id)
	{
		Query query = new Query(Criteria.where("id").is(id));
		Update update=new Update();
		String objectName=uncapitalize(object.getClass().getSimpleName().replace("Impl", ""));
		update.set(objectName, object);
		boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
		Update updateClass=new Update();
		String objectClass=objectName+"._class";
		updateClass.set(objectClass,object.getClass().getCanonicalName());
		mongoOperations.updateFirst(query, updateClass, Resume.class);
		
		return result;
		
	}

	public Objective getObjective(Object object) {
		
		String key=(String)object;
		
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("objective");
		 query.fields().exclude("_id");
		 return mongoOperations.findOne(query,Resume.class).getObjective();
		
	}

	public boolean setObjective(Objective objective) {
		 
		mongoOperations.save(objective);
		
		return true;
		

	}

	public PersonalDetails getPersonalDetails(Object object) {
		String key=(String)object;
		
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("personalDetails");
		 query.fields().exclude("_id");
		// System.out.println(mongoOperations.findOne(query,Resume.class).getPersonalDetails());
		 return mongoOperations.findOne(query,Resume.class).getPersonalDetails();
		
	}

/*	public boolean setPersonalDetails(PersonalDetails personalDetails, String id) {
		 
			Query query = new Query(Criteria.where("id").is(id));
			Update update=new Update();
			update.set("personalDetails", personalDetails);
			//update.set("personalDetails.class",personalDetails.getClass().getCanonicalName());
			boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
			
			Update updateClass=new Update();
			updateClass.set("personalDetails._class",personalDetails.getClass().getCanonicalName());
			mongoOperations.updateFirst(query, updateClass, Resume.class);
			return result;

	}
*/
	public List<Skills> getSkills(Object object) {
		String key=(String)object;
		
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("skills");
		 query.fields().exclude("_id");
		 return mongoOperations.findOne(query,Resume.class).getSkills();
	}

/*	public boolean setSkills(Skills skills, String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("skills", skills);
		boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
		Update updateClass=new Update();
		updateClass.set("skills._class",skills.getClass().getCanonicalName());
		mongoOperations.updateFirst(query, updateClass, Resume.class);

		return result;

	}
*/
	public List<Experience> getExperience(Object object) {
		String key=(String)object;
		
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("experience");
		 query.fields().exclude("_id");
		 return mongoOperations.findOne(query,Resume.class).getExperience();	 
	}

/*	public boolean setExperience(Experience experience, String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("experience", experience);
		boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
		Update updateClass=new Update();
		updateClass.set("experience._class",experience.getClass().getCanonicalName());
		mongoOperations.updateFirst(query, updateClass, Resume.class);

		return result;

	}
*/
	public List<Education> getEducation(Object object) {
		String key=(String)object;
		
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("education");
		 query.fields().exclude("_id");
		 return mongoOperations.findOne(query,Resume.class).getEducation();
	}
/*
	public boolean setEducation(Education education, String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("education", education);
		boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
		Update updateClass=new Update();
		updateClass.set("education._class",education.getClass().getCanonicalName());
		mongoOperations.updateFirst(query, updateClass, Resume.class);

		return result;

	}
*/
	public List<Publications> getPublications(Object object) {
		String key=(String)object;
		
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("publications");
		 query.fields().exclude("_id");
		 return mongoOperations.findOne(query,Resume.class).getPublications();
	}

/*	public boolean setPublications(Publications publication, String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("publication", publication);
		boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
		Update updateClass=new Update();
		updateClass.set("publication._class",publication.getClass().getCanonicalName());
		mongoOperations.updateFirst(query, updateClass, Resume.class);

		return result;

	}
*/
	public List<References> getReferences(Object object) {
		 String key=(String)object;
		 Query query = new Query(Criteria.where("id").is(key));
		 query.fields().include("references");
		 query.fields().exclude("_id");
		 return mongoOperations.findOne(query,Resume.class).getReferences();
	}

/*	public boolean setReferences(References references, String id) {
		Query query = new Query(Criteria.where("id").is(id));
		Update update=new Update();
		update.set("References", references);
		boolean result=mongoOperations.updateFirst(query, update, Resume.class) != null;
		Update updateClass=new Update();
		updateClass.set("references._class",references.getClass().getCanonicalName());
		mongoOperations.updateFirst(query, updateClass, Resume.class);

		return result;
	}
*/	
}
