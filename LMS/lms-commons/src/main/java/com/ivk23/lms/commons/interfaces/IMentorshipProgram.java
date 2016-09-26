package com.ivk23.lms.commons.interfaces;

import java.util.Date;
import java.util.List;

public interface IMentorshipProgram {
	
	Long getId();
	
	String getName();
	
	String getOffice();
	
	Date getStartDate();
	
	Date getEndDate();
	
	List<IPhase> getPhases();
	
	void setPhases(List<IPhase> phases);

	String getCreatedBy();

	Date getCreationDate();

}
