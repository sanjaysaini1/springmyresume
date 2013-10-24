package com.springmyresume.resume.skills;


import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document
@Component("skills")
@Scope("request")
public interface Skills {

	public String getSkilltype();
	public void setSkilltype(String skilltype);
	public String getSkillname();
	public void setSkillname(String skillname);
	public String getUsedSince();
	public void setUsedSince(String usedSince);
	public String getLastUsed();
	public void setLastUsed(String lastUsed);
	public int getRank();
	public void setRank(int rank);
	
	public List<SkillsImpl> getSubSkills();
	public void setSubSkills(List<SkillsImpl> subSkills);
	@Override
	public String toString();

	@Override
	public boolean equals(Object obj);
	
	/*public String getId();
	public void setId(String id) ;
	*/
}
