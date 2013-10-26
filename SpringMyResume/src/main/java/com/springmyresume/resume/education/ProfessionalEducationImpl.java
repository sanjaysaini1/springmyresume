package com.springmyresume.resume.education;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component

public class ProfessionalEducationImpl extends EducationImpl {

	private static final long serialVersionUID = 1359120804470719643L;

	public ProfessionalEducationImpl(){super();};
	public ProfessionalEducationImpl(String degree, String institution,
			String location, double marksObtained, double maximumMarks,
			String remarks,String yearofJoining,String yearofPassing) {
		super(degree, institution, location, marksObtained, maximumMarks, remarks,yearofJoining,yearofPassing);
		// TODO Auto-generated constructor stub
	}

}
