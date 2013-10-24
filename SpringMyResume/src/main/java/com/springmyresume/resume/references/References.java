package com.springmyresume.resume.references;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document
@Component

public interface References {

	public String getReferenceName();
	public void setReferenceName(String referenceName);
	public String getReferenceAddress();
	public void setReferenceAddress(String referenceAddress);
	public String getReferenceContactNumber();
	public void setReferenceContactNumber(String referenceContactNumber);
	/*public String getId();
	public void setId(String id) ;
	*/
}
