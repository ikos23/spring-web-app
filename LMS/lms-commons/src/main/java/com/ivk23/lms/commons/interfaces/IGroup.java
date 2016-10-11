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

	/**
	 * Returns duration in days. Duration is calculated upon
	 * actual Start and End dates of the program. When program
	 * actualEndDate is set - duration is calculated and set as well.
	 * 
	 * @return Number of days the program lasts.
	 */
	Integer getDuration();

}
