package com.springmyresume.sitemaker;


public interface SiteBuilder {

	public void buildLocation();
	 public void buildIndexPage();
	 public void buildEducationPage();
	 public void buildExperiencePage();
	 public void buildSkillsPage();
	 public void buildReferencesPage();
	 public void buildPublicationsPage();
	 public void createZipSite();
	 public void buildCss();
	 public void buildJs();
	public Site getSite();
}
