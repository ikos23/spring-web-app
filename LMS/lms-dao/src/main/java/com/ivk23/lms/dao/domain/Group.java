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

import com.ivk23.lms.commons.interfaces.IGroup;

@Entity
@Table(name = "MtGroup")
@SequenceGenerator(name = "GRP_SEQ", sequenceName = "GRP_SEQ")
public class Group implements IGroup, Serializable {
 
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_BY_MENTEE_NUMBERS = "findMentorsByMenteeNumbers";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRP_SEQ")
	private Long id;
	
	public Group() {
		super();
	}
	
	public Group(Employee mentor, Employee mentee, Date palnnedStartDate, Date palnnedEndDate,
			Date actualStartDate, Date actualEndDate, Status status) {
		super();
		this.mentor = mentor;
		this.mentee = mentee;
		this.palnnedStartDate = palnnedStartDate;
		this.palnnedEndDate = palnnedEndDate;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.status = status;
	}



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mentor_id", nullable = false)
	private Employee mentor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mentee_id", nullable = false)
	private Employee mentee;
	
	@Column(name = "planned_start", nullable = false)
	private Date palnnedStartDate;
	
	@Column(name = "planned_end", nullable = false)
	private Date palnnedEndDate;
	
	@Column(name = "actual_start", nullable = true)
	private Date actualStartDate;
	
	@Column(name = "actual_end", nullable = true)
	private Date actualEndDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", nullable = true)
	private Status status;
	
	@Column(name = "duration")
	private Integer duration;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Employee getMentor() {
		return mentor;
	}

	@Override
	public Employee getMentee() {
		return mentee;
	}

	@Override
	public Date getPalnnedStartDate() {
		return palnnedStartDate;
	}

	@Override
	public Date getPalnnedEndDate() {
		return palnnedEndDate;
	}

	@Override
	public Date getActualStartDate() {
		return actualStartDate;
	}

	@Override
	public Date getActualEndDate() {
		return actualEndDate;
	}

	@Override
	public Status getStatus() {
		return status;
	}
	
	@Override
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMentor(Employee mentor) {
		this.mentor = mentor;
	}

	public void setMentee(Employee mentee) {
		this.mentee = mentee;
	}

	public void setPalnnedStartDate(Date palnnedStartDate) {
		this.palnnedStartDate = palnnedStartDate;
	}

	public void setPalnnedEndDate(Date palnnedEndDate) {
		this.palnnedEndDate = palnnedEndDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	
	
	
}
