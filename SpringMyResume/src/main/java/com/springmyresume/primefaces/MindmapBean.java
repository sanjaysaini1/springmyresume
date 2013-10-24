package com.springmyresume.primefaces;

import java.io.Serializable;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.springmyresume.db.dbdata.ResumeDao;
import com.springmyresume.resume.Resume;
import com.springmyresume.resume.education.Education;
import com.springmyresume.resume.experience.Experience;
import com.springmyresume.resume.personeldetails.PersonalDetails;
import com.springmyresume.resume.skills.Skills;

@Component
@Scope("session")

public class MindmapBean implements Serializable {

	private static final long serialVersionUID = 1717100870327316916L;

	private MindmapNode root;

    private MindmapNode selectedNode;
   // private CartesianChartModel categoryModel;
    private Resume newresume;
    private PersonalDetails personalDetails;
   static{
	 //  System.out.println("In mind map bean 0");
	//   SpringMyResumeRun.go();
   }
    
    public MindmapBean() {
    	
    	
   System.out.println("In mind map bean");
       
   getResumefromDB();
   
       root=new DefaultMindmapNode(newresume.getPersonalDetails().getName(), "Resume", "6e9ebf", true);
       
   	root.addNode(new DefaultMindmapNode("Personal Details","Personal stuff","3399ff", true));
	root.addNode(new DefaultMindmapNode("Skills","skills","3399ff", true));
	root.addNode(new DefaultMindmapNode("Education","education","3399ff", true));
	root.addNode(new DefaultMindmapNode("Experience","employement","3399ff", true));
	  //createCategoryModel();
	
  
    }
    
    public Resume getResumefromDB()
    {
    	
        ApplicationContext myappcontext=new ClassPathXmlApplicationContext("beans.xml");
      this.personalDetails =(PersonalDetails)myappcontext.getBean("personalDetails");
        String id=personalDetails.getEmailId()+personalDetails.getContactNumber();
        ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");
		ResumeDao resumeDao=(ResumeDao)ctx.getBean("resumeDao");
		 newresume=resumeDao.getResume(id);
		  
		  return newresume;
    }
    public Resume getResumefromDB(String id)
    {
    	

        ApplicationContext ctx = new GenericXmlApplicationContext("mongo-config.xml");
		ResumeDao resumeDao=(ResumeDao)ctx.getBean("resumeDao");
		 newresume=resumeDao.getResume(id);
		 System.out.println("RESSSUME: "+newresume);
		  personalDetails=newresume.getPersonalDetails();
		  return newresume;
    }
    
    public MindmapBean(String id) {
    	
    	 System.out.println("ID:"+id);
    		getResumefromDB( id);
    	    	
    	    root=new DefaultMindmapNode(newresume.getPersonalDetails().getName(), "Resume", "6e9ebf", true);
    	       
    	   	root.addNode(new DefaultMindmapNode("Personal Details","Personal stuff","3399ff", true));
    		root.addNode(new DefaultMindmapNode("Skills","skills","3399ff", true));
    		root.addNode(new DefaultMindmapNode("Education","education","3399ff", true));
    		root.addNode(new DefaultMindmapNode("Experience","employement","3399ff", true));
    		  //createCategoryModel();
    		
    	    }

    public MindmapNode getRoot() {
        return root;
    }

    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void onNodeSelect(SelectEvent event) {
    	MindmapNode node = (MindmapNode) event.getObject();
	  
      
       // System.out.println("IN Single CLICK");
        
         if(node.getChildren().isEmpty()) {
        //	  System.out.println("IN Single CLICK 1");
            Object label = node.getLabel();

            if(label.equals("Skills")) {
                for(Skills skill : newresume.getSkills() ) {
                    node.addNode(new DefaultMindmapNode(skill.getSkillname(), skill, "82c542",false));
                }
            }
            else if(label.equals("Experience")) {
            	 for(Experience experience : newresume.getExperience() ) {
                     node.addNode(new DefaultMindmapNode(experience.getCompany()+" "+experience.getStartDate()+"-"+experience.getEndDate(), experience, "82c542",false));
                 }

            }
            else if(label.equals("Education")) {
            	 for(Education education : newresume.getEducation() ) {
                     node.addNode(new DefaultMindmapNode(education.getDegree()+" at "+education.getInstitution(), education, "82c542",false));
                 }
              }
            else if(label.equals("Personal Details")) {
           	 
                    node.addNode(new DefaultMindmapNode("Email: "+ personalDetails.getEmailId(), personalDetails, "82c542",false));
                    node.addNode(new DefaultMindmapNode("DOB: "+ personalDetails.getDateOfBirth(), personalDetails, "82c542",false));
                    node.addNode(new DefaultMindmapNode("Mobile: "+ personalDetails.getContactNumber(), personalDetails, "82c542",false));
            }
        }
        // System.out.println("IN Single CLICK 3");
        
    }
 /* public CartesianChartModel getCategoryModel() {
    	
        return categoryModel;
    }*/
  
    public void onNodeDblselect(SelectEvent event) {
    	
    //	System.out.println("IN DOUBLE CLICK");
    	
        this.selectedNode = (MindmapNode) event.getObject();      
     //   System.out.println("IN DOUBLE CLICK 2");
    }
    
   /* private void createCategoryModel() {
        categoryModel = new CartesianChartModel();
    }*/
}


