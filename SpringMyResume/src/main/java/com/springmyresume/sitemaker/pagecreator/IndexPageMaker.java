package com.springmyresume.sitemaker.pagecreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmyresume.resume.Resume;
import com.springmyresume.resume.utility.Utility;

public class IndexPageMaker extends PageMaker {

	

	@Override
	public List<MenuItem> getMenu(Resume resume) {
		List<MenuItem> menu=new ArrayList<MenuItem>();
		menu.add(new MenuItem("index.html", "Personal Details"));
		menu.add(new MenuItem("html/skills.html","Skills"));
		menu.add(new MenuItem("html/experience.html","Experience"));
		menu.add(new MenuItem("html/education.html","Education"));
		Utility.p("YABABA"+resume.toString());
		if(resume.getPublications()!=null)
		{
			menu.add(new MenuItem("html/publications.html","Publications"));
		}
		if(resume.getReferences()!=null)
		{
			menu.add(new MenuItem("html/references.html","References"));
		}
			
		return menu;
	}

	@Override
	public Map<String, Object> getDisplayMap(Resume resume) {
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("Name", resume.getPersonalDetails().getName());
		map.put("Date of Birth", resume.getPersonalDetails().getDateOfBirth());
		map.put("Address", resume.getPersonalDetails().getAddress());
		map.put("Email Address", resume.getPersonalDetails().getEmailId());
		map.put("Contact Number", resume.getPersonalDetails().getContactNumber());
		map.put("Spoken Languages", resume.getPersonalDetails().getLanguagesKnown());
		map.put("Interests", resume.getPersonalDetails().getInterests());
		
		return map;
	}

}
