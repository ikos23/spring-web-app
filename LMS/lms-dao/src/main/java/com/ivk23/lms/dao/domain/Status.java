package com.ivk23.lms.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ivk23.lms.commons.interfaces.IStatus;

@Entity
@Table(name = "Status")
public class Status implements IStatus, Serializable {
 
	private static final long serialVersionUID = -7866289492853789810L;

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
		return "Status [id=" + id + ", name=" + name + "]";
	}
	
}
