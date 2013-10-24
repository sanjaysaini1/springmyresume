package com.springmyresume.sitemaker;

public class SiteMaker {

	 private SiteBuilder siteBuilder;

	public SiteMaker(SiteBuilder siteBuilder) {
		super();
		this.siteBuilder = siteBuilder;
	}
	 
	public Site getSite(){
	return this.siteBuilder.getSite();	
	}
	public void makeSite()
	{
		this.siteBuilder.buildLocation();
		this.siteBuilder.buildIndexPage();
		this.siteBuilder.buildSkillsPage();
		this.siteBuilder.buildEducationPage();
		this.siteBuilder.buildExperiencePage();
		this.siteBuilder.buildPublicationsPage();
		this.siteBuilder.buildReferencesPage();
		this.siteBuilder.buildCss();
		this.siteBuilder.buildJs();
		this.siteBuilder.createZipSite();
	}
	
}
