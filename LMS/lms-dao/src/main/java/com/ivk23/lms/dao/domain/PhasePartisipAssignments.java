package com.ivk23.lms.dao.domain;

import java.io.Serializable;

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

import com.ivk23.lms.commons.interfaces.IPhasePartisipAssignments;

@Entity
@Table(name = "PhasePartisipAssignments")
@SequenceGenerator(name = "PPA_SEQ", sequenceName = "PPA_SEQ")
public class PhasePartisipAssignments implements IPhasePartisipAssignments, Serializable {
 
	private static final long serialVersionUID = 6473514440757650556L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PPA_SEQ")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "phase_id", nullable = false)
	private Phase phase;
	
	@Column(name = "status", nullable = false)
	private String status;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Employee getEmployee() {
		return employee;
	}

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PhasePartisipAssignments [id=" + id + ", employee=" + employee + ", role=" + role + ", status=" + status
				+ "]";
	}
	

}
