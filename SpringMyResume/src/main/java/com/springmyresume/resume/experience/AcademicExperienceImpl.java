package com.springmyresume.resume.experience;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Document
@Component

public class AcademicExperienceImpl extends ExperienceImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4599505044907096375L;

	
	public AcademicExperienceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AcademicExperienceImpl(String company, String startDate, String endDate,
			List<Project> projectList, String remarks) {
		super(company, startDate, endDate, projectList, remarks);
		// TODO Auto-generated constructor stub
	}

}
