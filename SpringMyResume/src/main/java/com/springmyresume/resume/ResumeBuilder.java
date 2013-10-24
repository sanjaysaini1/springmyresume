package com.springmyresume.resume;


public interface ResumeBuilder {

	public void buildRid();
	public void buildObjective();
	public void buildPersonelDetails();
	public void buildSkills();
	public void buildExperience();
	public void buildEducation();
	public void buildPublications();
	public void buildReferences();
	
    public void setResume(Resume resume);
	public Resume getResume();
	
}
