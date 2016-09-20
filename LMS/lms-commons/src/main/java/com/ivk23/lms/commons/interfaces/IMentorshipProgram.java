package com.ivk23.lms.commons.interfaces;

import java.util.Date;
import java.util.List;

public interface IMentorshipProgram {
	
	public Long getId();
	
	public String getName();
	
	public String getOffice();
	
	public Date getStartDate();
	
	public Date getEndDate();
	
	public List<IPhase> getPhases();
	
	public void setPhases(List<IPhase> phases);

}
