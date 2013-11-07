package com.springmyresume.resume.skills;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;

@Document
@Component
@Scope("request")
public class SkillsImpl implements EmbeddedResumeObject,Skills,Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 436300417318172425L;
	private String skilltype;
	private String skillname;
	
	private String usedSince;
	private String lastUsed;
	private int rank;
	private List<SkillsImpl> subSkills;
	/*
	@Id
	private ObjectId id;
  
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/	

	public SkillsImpl(String skilltype, String skillname, String usedSince,
			String lastUsed, int rank) {
		super();
		this.skilltype = skilltype;
		this.skillname = skillname;
		this.usedSince = usedSince;
		this.lastUsed = lastUsed;
		this.rank = rank;
		
	}
	
	public SkillsImpl(){
		super();
		//System.out.println("Skills Impl");
	}
	
	public String getSkilltype() {
		return skilltype;
	}
	public void setSkilltype(String skilltype) {
		this.skilltype = skilltype;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String getUsedSince() {
		return usedSince;
	}
	public void setUsedSince(String usedSince) {
		
		try {
			Date d= new SimpleDateFormat( "EEE MMM dd HH:mm:ss Z yyyy").parse(usedSince);
			this.usedSince= new SimpleDateFormat("dd/MM/YYYY").format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//Utility.p("Date conversion failed");
			this.usedSince = usedSince;
		}
		
		//this.usedSince = usedSince;
	}
	public String getLastUsed() {
		return lastUsed;
	}
	public void setLastUsed(String lastUsed) {
		
		try {
			Date d= new SimpleDateFormat( "EEE MMM dd HH:mm:ss Z yyyy").parse(lastUsed);
			this.lastUsed= new SimpleDateFormat("dd/MM/YYYY").format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//Utility.p("Date conversion failed");
			this.lastUsed = lastUsed;
		}
		
		
	//	this.lastUsed = lastUsed;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public List<SkillsImpl> getSubSkills() {
		return subSkills;
	}
	public void setSubSkills(List<SkillsImpl> subSkills) {
		this.subSkills = subSkills;
	}
	

	@Override
	public String toString() {
		return "SkillsImpl [skilltype=" + skilltype + ", skillname="
				+ skillname + ", usedSince=" + usedSince + ", lastUsed="
				+ lastUsed + ", rank=" + rank + ", subSkills=" + subSkills
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		SkillsImpl compareobject=(SkillsImpl)obj;
		if(this.toString().equalsIgnoreCase(compareobject.toString()))
		{
			return true;
		}
		else
			return false;

	}
	
	
	
	
}
