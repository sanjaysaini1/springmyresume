package com.springmyresume.resume.experience;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component

public class Internship extends ExperienceImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3108734879597327209L;

	public Internship()
	{
		super();
	}
	public Internship(String company, String startDate, String endDate,
			List<Project> projectList, String remarks) {
		super(company, startDate, endDate, projectList, remarks);
		// TODO Auto-generated constructor stub
	}

}
