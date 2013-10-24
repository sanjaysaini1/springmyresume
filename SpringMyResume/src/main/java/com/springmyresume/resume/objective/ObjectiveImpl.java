package com.springmyresume.resume.objective;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.springmyresume.resume.EmbeddedResumeObject;


@Component
@Scope("request")
public class ObjectiveImpl implements EmbeddedResumeObject,Objective,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8355330273493874522L;
	
	private String objective;

	
	
	
	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	@Override
	public String toString() {
		return "ObjectiveImpl [objective=" + objective + "]";
	}
	
	
}
