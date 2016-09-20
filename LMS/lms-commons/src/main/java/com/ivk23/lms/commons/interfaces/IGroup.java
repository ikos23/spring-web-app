package com.ivk23.lms.commons.interfaces;

import java.util.Date;

public interface IGroup {

	Long getId();

	IEmployee getMentor();

	IEmployee getMentee();

	Date getPalnnedStartDate();

	Date getPalnnedEndDate();

	Date getActualStartDate();

	Date getActualEndDate();

	IStatus getStatus();

}
