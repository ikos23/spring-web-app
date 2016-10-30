package com.ivk23.lms.dao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ivk23.lms.commons.interfaces.IPhase;

@Entity
@Table(name = "Phase")
@SequenceGenerator(name = "PHASE_SEQ", sequenceName = "PHASE_SEQ")
public class Phase implements IPhase, Serializable {
 
	private static final long serialVersionUID = 277169801518285175L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHASE_SEQ")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mt_program_id")
	@JsonIgnore
	private MentorshipProgram mentorshipProgram;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	public Phase() {
		super();
	}

	public Phase(String name, MentorshipProgram mentorshipProgram, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.mentorshipProgram = mentorshipProgram;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public MentorshipProgram getMentorshipProgram() {
		return mentorshipProgram;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "Phase [id=" + id + ", name=" + name + ", mentorshipProgram=" + mentorshipProgram + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	

}
