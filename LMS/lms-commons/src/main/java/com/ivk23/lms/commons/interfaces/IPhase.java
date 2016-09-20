package com.ivk23.lms.commons.interfaces;

import java.util.Date;

public interface IPhase {
	
	public Long getId();

	public String getName();

	public IMentorshipProgram getMentorshipProgram();

	public Date getStartDate();

	public Date getEndDate();

}
