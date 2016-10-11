package com.ivk23.lms.web.ui.models;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.commons.interfaces.IPhase;
import com.ivk23.lms.commons.interfaces.IPhasePartisipAssignments;
import com.ivk23.lms.commons.interfaces.IRole;

public class ParticipantAssignment implements IPhasePartisipAssignments {
	
	private Long id;
	private Long employeeID;
	private Long roleID;
	private Long phaseID;
	private String status;
	

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}

	public void setPhaseID(Long phaseID) {
		this.phaseID = phaseID;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public IEmployee getEmployee() {
		return new Employee().setId(this.employeeID);
	}

	@Override
	public IRole getRole() {
		return new Role(this.roleID);
	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public IPhase getPhase() {
		return new Phase().setId(this.phaseID);
	}

}
