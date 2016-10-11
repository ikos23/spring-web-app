package com.ivk23.lms.web.ui.models;

import com.ivk23.lms.commons.interfaces.IRole;

public class Role implements IRole {
	
	private Long roleId;

	public Role() {
		super();
	}
	
	public Role(Long roleId) {
		super();
		this.roleId = roleId;
	}
	
	public Role setRoleId(Long roleId) {
		this.roleId = roleId;
		return this;
	}

	@Override
	public Long getId() {
		return this.roleId;
	}

	@Override
	public String getName() {
		return null;
	}

}
