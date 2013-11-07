package com.springmyresume.sitemaker.pagecreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springmyresume.resume.Resume;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class PageMaker {
	
	public Template getTemplate(String templatefile) throws IOException
	{
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(PageMaker.class, "/");
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		Template template = configuration.getTemplate(templatefile);
		return template;
	}
	
	public  Map<String, Object> getMap(List<MenuItem> menu,Map<String,Object> map,Resume resume)
	{
		Map<String,Object> root=new HashMap<String, Object>();
		root.put("name", resume.getPersonalDetails().getName());
		root.put("menu", menu);
		root.put("displaymap", map);
		if(!(resume.getObjective()==null))
		{
			root.put("objective", resume.getObjective().getObjective());
		}
		return root;
	}
	
	
	public void writePage(String pagename, Template template, Map<String,Object> root,String location)
	{
		Writer file;
		try {
			
			
			String filename= "."+"/"+location+"/"+pagename;
			//System.out.println("FILE"+filename);
			File html=new File(filename);
			if(html.getParentFile()!=null)
			{
				html.getParentFile().mkdirs();
			}
			//System.out.println(html.getAbsolutePath());
			file = new FileWriter(html);
			
			 template.process(root, file);
		      file.flush();
		      file.close();
		      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     

	}
	
	public List<MenuItem> getMenu(Resume resume) {
		List<MenuItem> menu=new ArrayList<MenuItem>();
		menu.add(new MenuItem("../index.html", "Personal Details"));
		menu.add(new MenuItem("skills.html","Skills"));
		menu.add(new MenuItem("experience.html","Experience"));
		menu.add(new MenuItem("education.html","Education"));
		if(resume.getPublications()!=null)
		{
			menu.add(new MenuItem("publications.html","Publications"));
		}
		if(resume.getReferences()!=null)
		{
			menu.add(new MenuItem("references.html","References"));
		}
			
		return menu;
	}
	
	//public abstract List<MenuItem> getMenu(Resume resume);
	public abstract Map<String,Object> getDisplayMap(Resume resume);
	
}
