package com.springmyresume.run;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springmyresume.db.dbdata.ResumeDao;
import com.springmyresume.resume.Resume;
import com.springmyresume.resume.education.Education;
import com.springmyresume.resume.experience.Experience;
import com.springmyresume.resume.objective.Objective;
import com.springmyresume.resume.objective.ObjectiveImpl;
import com.springmyresume.resume.personeldetails.PersonalDetails;
import com.springmyresume.resume.skills.Skills;
import com.springmyresume.sitemaker.SimpleSiteBuilder;
import com.springmyresume.sitemaker.SiteBuilder;
import com.springmyresume.sitemaker.SiteMaker;

public class SpringMyResumeRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

		ApplicationContext myappcontext=new ClassPathXmlApplicationContext("beans.xml");
	
	
	PersonalDetails personalDetails =(PersonalDetails)myappcontext.getBean("personalDetails");
	System.out.println("PERSONAL DETAILS: "+personalDetails);
	Skills skillsjava=(Skills)myappcontext.getBean("skills");
	Skills skillsweb=(Skills)myappcontext.getBean("skillsWeb");
	Skills skillsothers=(Skills)myappcontext.getBean("skillsOthers");
	
	Experience experienceAmdocs=(Experience)myappcontext.getBean("experienceAmdocs");
	Experience experienceGOI=(Experience)myappcontext.getBean("experienceGOI");
	Experience experienceCogni=(Experience)myappcontext.getBean("experienceCogni");
	Experience experienceGifto=(Experience)myappcontext.getBean("experienceGifto");
	Experience experienceDojo=(Experience)myappcontext.getBean("experienceDojo");
	
	Education educationCollege=(Education)myappcontext.getBean("educationCollege");
	Education educationTenth=(Education)myappcontext.getBean("educationTenth");
	Education educationSchool=(Education)myappcontext.getBean("educationSchool");
	String id=personalDetails.getEmailId()+personalDetails.getContactNumber();
   // PersonalDetails personalDetailsX=(PersonalDetails)myappcontext.getBean("personalDetailsX");
	//personalDetails.setId(id);
	Objective objective =new ObjectiveImpl();
	objective.setObjective("Seeking a responsible and challenging position in a growth oriented progressive Institution where my experience and skills will significantly contribute to the overall success of the organisation and provide opportunities for my career growth.");
    System.out.println(personalDetails);
		Resume resume=new Resume();
		resume.setId(personalDetails.getEmailId()+personalDetails.getContactNumber());
		resume.setPersonalDetails(personalDetails);
		List<Education> edulist=new ArrayList<Education>();
		//System.out.println("EDUCATION EDUCATION\n+++++++\n"+educationCollege);
	
		edulist.add(educationTenth);
		edulist.add(educationSchool);
		edulist.add(educationCollege);
		resume.setEducation(edulist);
	
		List<Experience> explist=new ArrayList<Experience>();
		explist.add(experienceAmdocs);
		explist.add(experienceGOI);
		explist.add(experienceCogni);
		explist.add(experienceGifto);
		explist.add(experienceDojo);
		
		resume.setExperience(explist);
		List<Skills> skillslist=new ArrayList<Skills>();
		skillslist.add(skillsjava);
		skillslist.add(skillsweb);
		skillslist.add(skillsothers);
		resume.setSkills(skillslist);
		resume.setObjective(objective);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++"+resume);
		ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");
		ResumeDao resumeDao=(ResumeDao)ctx.getBean("resumeDao");
	System.out.println("RESUME:"+resume);
	  
		  resumeDao.setResume(resume);
		  
		  //System.out.println(resumeDao.getResume(id));
		 // System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");	
		  
		  Resume newresume=resumeDao.getResume(id);
		  System.out.println("NEW RESUME\n"+newresume);
		  SiteBuilder siteBuilder=new SimpleSiteBuilder(newresume);
		  SiteMaker siteMaker=new SiteMaker(siteBuilder);
		  siteMaker.makeSite();
  
	}

 public  static void go()
 {

		ApplicationContext myappcontext=new ClassPathXmlApplicationContext("beans.xml");
	
	
	PersonalDetails personalDetails =(PersonalDetails)myappcontext.getBean("personalDetails");
	Skills skillsjava=(Skills)myappcontext.getBean("skills");
	Skills skillsweb=(Skills)myappcontext.getBean("skillsWeb");
	Skills skillsothers=(Skills)myappcontext.getBean("skillsOthers");
	
	Experience experienceAmdocs=(Experience)myappcontext.getBean("experienceAmdocs");
	Experience experienceGOI=(Experience)myappcontext.getBean("experienceGOI");
	Experience experienceCogni=(Experience)myappcontext.getBean("experienceCogni");
	Experience experienceGifto=(Experience)myappcontext.getBean("experienceGifto");
	Experience experienceDojo=(Experience)myappcontext.getBean("experienceDojo");
	
	Education educationCollege=(Education)myappcontext.getBean("educationCollege");
	Education educationTenth=(Education)myappcontext.getBean("educationTenth");
	Education educationSchool=(Education)myappcontext.getBean("educationSchool");
	String id=personalDetails.getEmailId()+personalDetails.getContactNumber();
// PersonalDetails personalDetailsX=(PersonalDetails)myappcontext.getBean("personalDetailsX");
	//personalDetails.setId(id);
	Objective objective =new ObjectiveImpl();
	objective.setObjective("Seeking a responsible and challenging position in a growth oriented progressive Institution where my experience and skills will significantly contribute to the overall success of the organisation and provide opportunities for my career growth.");
 
		Resume resume=new Resume();
		resume.setId(personalDetails.getEmailId()+personalDetails.getContactNumber());
		resume.setPersonalDetails(personalDetails);
		List<Education> edulist=new ArrayList<Education>();
		System.out.println("EDUCATION EDUCATION\n+++++++\n"+educationCollege);
	
		edulist.add(educationTenth);
		edulist.add(educationSchool);
		edulist.add(educationCollege);
		resume.setEducation(edulist);
	
		List<Experience> explist=new ArrayList<Experience>();
		explist.add(experienceAmdocs);
		explist.add(experienceGOI);
		explist.add(experienceCogni);
		explist.add(experienceGifto);
		explist.add(experienceDojo);
		
		resume.setExperience(explist);
		List<Skills> skillslist=new ArrayList<Skills>();
		skillslist.add(skillsjava);
		skillslist.add(skillsweb);
		skillslist.add(skillsothers);
		resume.setSkills(skillslist);
		resume.setObjective(objective);
		 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++"+resume);
		ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");
		ResumeDao resumeDao=(ResumeDao)ctx.getBean("resumeDao");
	
	  
		  resumeDao.setResume(resume);
		  
		  System.out.println(resumeDao.getPersonalDetails(id));
		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");	
		  
		  /*Resume newresume=resumeDao.getResume(id);
		  SiteBuilder siteBuilder=new SimpleSiteBuilder(newresume);
		  SiteMaker siteMaker=new SiteMaker(siteBuilder);
		  siteMaker.makeSite();*/
 }
	
}
