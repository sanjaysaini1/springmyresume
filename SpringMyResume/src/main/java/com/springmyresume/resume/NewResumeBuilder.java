package com.springmyresume.resume;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.springmyresume.db.dbdata.ResumeDao;
import com.springmyresume.primefaces.MindmapBean;
import com.springmyresume.resume.education.Education;
import com.springmyresume.resume.education.EducationImpl;
import com.springmyresume.resume.education.Publications;
import com.springmyresume.resume.education.PublicationsImpl;
import com.springmyresume.resume.experience.Experience;
import com.springmyresume.resume.experience.ExperienceImpl;
import com.springmyresume.resume.experience.Project;
import com.springmyresume.resume.experience.ProjectImpl;
import com.springmyresume.resume.objective.Objective;
import com.springmyresume.resume.personeldetails.PersonalDetails;
import com.springmyresume.resume.references.References;
import com.springmyresume.resume.references.ReferencesImpl;
import com.springmyresume.resume.skills.Skills;
import com.springmyresume.resume.skills.SkillsImpl;
import com.springmyresume.resume.utility.Utility;
import com.springmyresume.sitemaker.SimpleSiteBuilder;
import com.springmyresume.sitemaker.SiteBuilder;
import com.springmyresume.sitemaker.SiteMaker;

@Component("resumeBuilder")
@Scope("session")
public class NewResumeBuilder implements ResumeBuilder, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Resume resume;

	 @ManagedProperty("#{mindmapBean}")
	 private MindmapBean mindmapBean;
	 
	@Autowired
	private Objective objective;

	@Autowired
	private PersonalDetails personalDetails;

	@Autowired
	private Skills skills;

	@Autowired
	private Experience experience;

	@Autowired
	private Project project;
	
	
	@Autowired
	private Education education;
	 

	@Autowired
	private References references;

	@Autowired
	private Publications publications;

	private List<Skills> skillsList;

	private List<Experience> experienceList;
	
	private List<Project> projectList;

	private List<Education> educationList;

	private List<References> referencesList;

	private List<Publications> publicationsList;
	
	private String resumeSitePath;
	

	public NewResumeBuilder() {
		super();
		//System.out.println("In resume builder");
		skillsList=new ArrayList<Skills>();
		experienceList=new ArrayList<Experience>();
		projectList=new ArrayList<Project>();
		educationList=new ArrayList<Education>();
		publicationsList=new ArrayList<Publications>();
		referencesList=new ArrayList<References>();
		// this.resume=new Resume();
	}

	public Resume getResume() {

		return resume;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public References getReferences() {
		return references;
	}

	public void setReferences(References references) {
		this.references = references;
	}

	public Publications getPublications() {
		return publications;
	}

	public void setPublications(Publications publications) {
		this.publications = publications;
	}

	public List<Skills> getSkillsList() {
		return skillsList;
	}

	public void setSkillsList(List<Skills> skillsList) {
		this.skillsList = skillsList;
	}

	public List<Experience> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<Experience> experienceList) {
		this.experienceList = experienceList;
	}

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}

	public List<References> getReferencesList() {
		return referencesList;
	}

	public void setReferencesList(List<References> referencesList) {
		this.referencesList = referencesList;
	}

	public List<Publications> getPublicationsList() {
		return publicationsList;
	}

	public void setPublicationsList(List<Publications> publicationsList) {
		this.publicationsList = publicationsList;
	}

	public MindmapBean getMindmapBean() {
		return mindmapBean;
	}

	public void setMindmapBean(MindmapBean mindmapBean) {
		this.mindmapBean = mindmapBean;
	}


	public String getResumeSitePath() {
		return resumeSitePath;
	}

	public void setResumeSitePath(String resumeSitePath) {
		this.resumeSitePath = resumeSitePath;
	}
	

	
	public void buildRid() {

	}

	public void buildObjective() {
		// TODO Auto-generated method stub

	}

	public void buildPersonelDetails() {
		// TODO Auto-generated method stub

	}

	public void buildSkills() {
		// TODO Auto-generated method stub

	}

	public void buildExperience() {
		// TODO Auto-generated method stub

	}

	public void buildEducation() {
		// TODO Auto-generated method stub

	}

	public void buildReferences() {
		// TODO Auto-generated method stub

	}

	public void buildPublications() {
		// TODO Auto-generated method stub

	}


	public void checkLogin()
	{
		Utility.p("In checklogin");
		
	}
	
	
	public String login()
	{
		Utility.p("In login");
		String id=this.getPersonalDetails().getEmailId()+this.getPersonalDetails().getContactNumber();
		ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");
		ResumeDao resumeDao=(ResumeDao)ctx.getBean("resumeDao");
		Resume localresume=resumeDao.getResume(id);
		//Utility.p(localresume.toString());
		if(localresume !=null)
		{
			try{
				this.mindmapBean=new MindmapBean(localresume.getId());
			}catch(Exception e)
			{
				e.printStackTrace();
				return "site-unavailable";
			}
			try{
				SiteBuilder siteBuilder=new SimpleSiteBuilder(localresume);
				  SiteMaker siteMaker=new SiteMaker(siteBuilder);
				  siteMaker.makeSite();
				  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
				     
				    //String serverRealPath = servletContext.getRealPath("/");
				    String serverContextPath = servletContext.getContextPath();
				    
				 this.resumeSitePath=serverContextPath+"/ZipSites/"+siteBuilder.getFileName();
				     
				    
				 // System.out.println("Location of Zip file: ");
			}catch(Exception e)
			{
				e.printStackTrace();
				//call edit function here. Not written yet.
				this.setPersonalDetails(localresume.getPersonalDetails());
				this.setEducationList(localresume.getEducation());
				this.setExperienceList(localresume.getExperience());
				
				return "site-exception";
			}
			
			return "site-exists";
		}else
		{
			return "site-unavailable";
		}
	}
	public String onFlowProcess(FlowEvent event) {

		return event.getNewStep();

	}
	
	public void addskills()
	{
		
		skillsList.add(skills);
		skills=new SkillsImpl();
	}
	
	public void reset()
	{
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
	}

	public void resetskills()
	{
		reset();
		 this.skillsList=new ArrayList<Skills>();

	}
	
	public void addprojects(){
		this.projectList.add(this.project);
		this.project=new ProjectImpl();
		
		
	}
	
	public void addexp(){
		this.experience.setProjectList(this.projectList);
		this.experienceList.add(this.experience);
		//System.out.println(experience);
		 this.projectList=new ArrayList<Project>();
		this.experience=new ExperienceImpl();
	}
	
	public void resetexp()
	{
		reset();
		 this.projectList=new ArrayList<Project>();
		 this.experienceList=new ArrayList<Experience>();

	}
	
	public void addedu(){

		this.educationList.add(this.education);
		//System.out.println(this.education);
		 
		this.education=new EducationImpl();
	}
	
	public void resetedu()
	{
		reset();
		 
		 this.educationList=new ArrayList<Education>();

	}
	

	public void addpub(){

		this.publicationsList.add(this.publications);
		//System.out.println(publications);
		 
		this.publications=new PublicationsImpl();
	}
	
	public void resetpub()
	{
		reset();
		 
		 this.publicationsList=new ArrayList<Publications>();

	}
	public void addref(){

		this.referencesList.add(this.references);
		//System.out.println(education);
		 
		this.references=new ReferencesImpl();
	}
	
	public void resetref()
	{
		reset();
		 
		 this.referencesList=new ArrayList<References>();

	}

	public String putResumeToDB() {
		//System.out.println("Clicked :");

		ApplicationContext ctx = new GenericXmlApplicationContext(
				"mongo-config.xml");
		ResumeDao resumeDao = (ResumeDao) ctx.getBean("resumeDao");
		//System.out.println("Resune :" + this);
		// resumeDao.setObjective(this.getObjective());
		Resume newresume = new Resume();
		if (this.objective.getObjective() != "") {
			newresume.setObjective(this.objective);
		}
		newresume.setPersonalDetails(this.personalDetails);
		newresume.setId(this.personalDetails.getEmailId()
				+ this.personalDetails.getContactNumber());
		newresume.setPersonalDetails(this.getPersonalDetails());
		newresume.setSkills(this.skillsList);
		newresume.setExperience(this.experienceList);
		newresume.setEducation(this.educationList);
		newresume.setPublications(this.publicationsList);
		newresume.setReferences(this.referencesList);
		//System.out.println("New Resune :" + newresume);
		if(resumeDao.setResume(newresume))
		{
			try{
				this.mindmapBean=new MindmapBean(newresume.getId());
			}catch(Exception e)
			{
				e.printStackTrace();
				return "failure";
			}
			try{
				SiteBuilder siteBuilder=new SimpleSiteBuilder(newresume);
				  SiteMaker siteMaker=new SiteMaker(siteBuilder);
				  siteMaker.makeSite();
				  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
				     
				    //String serverRealPath = servletContext.getRealPath("/");
				    String serverContextPath = servletContext.getContextPath();
				    
				 this.resumeSitePath=serverContextPath+"/ZipSites/"+siteBuilder.getFileName();
				     
				    
				 // System.out.println("Location of Zip file: ");
			}catch(Exception e)
			{
				e.printStackTrace();
				return "failure";
			}
			return "success";
		}else
		{
			return "failure";
		}
	}
	
	 
}
