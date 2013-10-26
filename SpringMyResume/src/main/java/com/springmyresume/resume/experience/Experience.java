package com.springmyresume.resume.experience;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component

public interface Experience {

	public String getCompany();
	public void setCompany(String company);
	public String getStartDate();
	public void setStartDate(String startDate);
	public String getEndDate();
	public void setEndDate(String endDate);
	public List<Project> getProjectList();
	public void setProjectList(List<Project> projectList);
	public String getRemarks();
	public void setRemarks(String remarks);

	/*public String getId();
	public void setId(String id) ;
*/
	@Override
	public String toString();
	
}
