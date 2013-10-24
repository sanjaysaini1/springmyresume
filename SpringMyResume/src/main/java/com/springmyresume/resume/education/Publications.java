package com.springmyresume.resume.education;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component
public interface Publications {

	public String getPaperName();
	public void setPaperName(String paperName);
	public String getConference();
	public void setConference(String conference);
	public String getJournal();
	public void setJournal(String journal);
	public int getYear();
	public void setYear(int year);
	public String getPaperDetails();
	public void setPaperDetails(String paperDetails);
	/*public String getId();
	public void setId(String id) ;*/
}
