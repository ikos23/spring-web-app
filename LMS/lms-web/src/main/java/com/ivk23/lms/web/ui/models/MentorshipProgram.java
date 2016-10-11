package com.ivk23.lms.web.ui.models;

import java.util.Date;
import java.util.List;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;

public class MentorshipProgram implements IMentorshipProgram {
	
	private Long id;
	private String name;
	private String office;
	private Date startDate;
	private Date endDate;
	private List<IPhase> phases;
	
	public MentorshipProgram() {
		super();
	}
	
	public MentorshipProgram(String name, String office, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.office = office;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public MentorshipProgram setId(Long id) {
		this.id = id;
		return this;
	}

	public MentorshipProgram setName(String name) {
		this.name = name;
		return this;
	}

	public MentorshipProgram setOffice(String office) {
		this.office = office;
		return this;
	}

	public MentorshipProgram setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	public MentorshipProgram setEndDate(Date endDate) {
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
	public String getOffice() {
		return this.office;
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
	public List<IPhase> getPhases() {
		return this.phases;
	}

	@Override
	public void setPhases(List<IPhase> phases) {
		this.phases = phases;

	}

	@Override
	public String getCreatedBy() {
		return null;
	}

	@Override
	public Date getCreationDate() {
		return null;
	}

	@Override
	public String toString() {
		return "MentorshipProgram [id=" + id + ", name=" + name + ", office=" + office + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", phases=" + phases + "]";
	}
	

}
