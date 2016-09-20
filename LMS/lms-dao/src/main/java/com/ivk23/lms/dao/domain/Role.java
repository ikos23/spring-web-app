package com.ivk23.lms.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ivk23.lms.commons.interfaces.IRole;

@Entity
@Table(name = "Role")
public class Role implements IRole, Serializable {
 
	private static final long serialVersionUID = -1421886733890187395L;
	
	@Id
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
}
