package com.springmyresume.resume;

//The director / engineer class creates a Resume using the
//builder interface that is defined (OldResumeBuilder)

public class ResumeEngineer {
	
	private ResumeBuilder ResumeBuilder;
	
	// OldResumeBuilder specification is sent to the engineer
	
	public ResumeEngineer(ResumeBuilder ResumeBuilder){
		
		this.ResumeBuilder = ResumeBuilder;
		
	}
	
	// Return the Resume made from the OldResumeBuilder spec
	
	public Resume getResume(){
		
		return this.ResumeBuilder.getResume();
		
	}
	
	// Execute the methods specific to the ResumeBuilder 
	// that implements ResumeBuilder (OldResumeBuilder)
	
	public void makeResume() {
		this.ResumeBuilder.buildRid();
		this.ResumeBuilder.buildObjective();
		this.ResumeBuilder.buildPersonelDetails();
		this.ResumeBuilder.buildSkills();
		this.ResumeBuilder.buildExperience();
		this.ResumeBuilder.buildEducation();
		this.ResumeBuilder.buildReferences();
	}
	
}