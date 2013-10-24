package com.springmyresume.resume.experience;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component

public interface Client {

	public String getClientName();
	public void setClientName(String clientName);
	public String getClientLocation();
	public void setClientLocation(String clientLocation);
	/*public String getId();
	public void setId(String id) ;*/
	public String toString();

}
