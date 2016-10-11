package com.ivk23.lms.web.ui.models;

import java.util.Date;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;

public class Phase implements IPhase {
	
	private Long id;
	private String name;
	private Date startDate;
	private Date endDate;
	private Long programID;
	
	public Phase() {
		super();
	}
	
	public Phase(String name, Date startDate, Date endDate, Long programID) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.programID = programID;
	}

	public Long getProgramID() {
		return programID;
	}

	public Phase setProgramID(Long programID) {
		this.programID = programID;
		return this;
	}

	public Phase setId(Long id) {
		this.id = id;
		return this;
	}

	public Phase setName(String name) {
		this.name = name;
		return this;
	}

	public Phase setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public Phase setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public IMentorshipProgram getMentorshipProgram() {
		return new MentorshipProgram().setId(this.programID);
	}

	@Override
	public Date getStartDate() {
		return this.startDate;
	}

	@Override
	public Date getEndDate() {
		return this.endDate;
	}

	@Override
	public String toString() {
		return "Phase [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", program="
				+ programID + "]";
	}

}
