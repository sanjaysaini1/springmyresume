package com.springmyresume.sitemaker.pagecreator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmyresume.resume.Resume;

public class EducationPageMaker extends PageMaker {

	@Override
	public Map<String, Object> getMap(List<MenuItem> menu,
			Map<String, Object> map, Resume resume) {
		Map<String,Object> root=new HashMap<String, Object>();
		root.put("name", resume.getPersonalDetails().getName());
		root.put("menu", menu);
		root.put("education", resume.getEducation());
		if(!(resume.getObjective()==null))
		{
			root.put("objective", resume.getObjective().getObjective());
		}
		
		return root;
	}

	@Override
	public Map<String, Object> getDisplayMap(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
