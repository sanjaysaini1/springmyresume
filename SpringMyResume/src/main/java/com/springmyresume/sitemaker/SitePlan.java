package com.springmyresume.sitemaker;

import com.springmyresume.sitemaker.pagecreator.PageMaker;

public interface SitePlan {
	
	public void setLocation(String location);
	 public void setIndexPage(PageMaker indexPage);
	 public void setEducationPage(PageMaker educationPage);
	 public void setExperiencePage(PageMaker experiencePage);
	 public void setSkillsPage(PageMaker skillsPage);
	 public void setReferencesPage(PageMaker referencesPage);
	 public void setPublicationsPage(PageMaker publicationsPage);
	
}
