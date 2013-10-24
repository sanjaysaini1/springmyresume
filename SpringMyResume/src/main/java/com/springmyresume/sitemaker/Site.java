package com.springmyresume.sitemaker;

import com.springmyresume.sitemaker.pagecreator.PageMaker;

public class Site implements SitePlan {

	String location;
	PageMaker indexPage;
	PageMaker educationPage;
	PageMaker experiencePage;
	PageMaker skillsPage;
	PageMaker referencesPage;
	PageMaker publicationsPage;
	
	public void setLocation(String location) {
		this.location=location;

	}

	public void setIndexPage(PageMaker indexPage) {
		this.indexPage=indexPage;
	

	}

	public void setEducationPage(PageMaker educationPage) {
	this.educationPage=educationPage;
	

	}

	public void setExperiencePage(PageMaker experiencePage) {
	this.experiencePage=experiencePage;

	}

	public void setSkillsPage(PageMaker skillsPage) {
		this.skillsPage=skillsPage;

	}

	public void setReferencesPage(PageMaker referencesPage) {
		this.referencesPage=referencesPage;

	}

	public void setPublicationsPage(PageMaker publicationsPage) {
		this.publicationsPage=publicationsPage;

	}

	
}
