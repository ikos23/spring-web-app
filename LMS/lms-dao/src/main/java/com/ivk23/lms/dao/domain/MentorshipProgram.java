package com.ivk23.lms.dao.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;
 
@Entity
@Table(name = "MTProgram")
@SequenceGenerator(name = "MP_SEQ", sequenceName = "MP_SEQ")
public class MentorshipProgram implements IMentorshipProgram, Serializable {
 
	private static final long serialVersionUID = -4704282471327516265L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MP_SEQ")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "office_location", nullable = false)
	private String office;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@Transient
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public List<IPhase> getPhases() {
		return phases;
	}
	
	@Override
	public void setPhases(List<IPhase> phases) {
		this.phases = phases;
		
	}

	@Override
	public String toString() {
		return "MentorshipProgram [id=" + id + ", name=" + name + ", office=" + office + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

}
