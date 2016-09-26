package com.ivk23.lms.dao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ivk23.lms.commons.interfaces.ILogs;

@Entity
@Table(name = "Logs")
@SequenceGenerator(name = "LOG_SEQ", sequenceName = "LOG_SEQ")
public class Logs implements ILogs, Serializable {
 
	private static final long serialVersionUID = 7631708057967835245L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_SEQ")
	private Long id;
	
	@Column(name = "method_name")
	private String method;
	
	@Column(name = "params")
	private String params;
	
	@Column(name = "invokation_date")
	private Date invokationDate;
	
	public Logs() {
		super();
	}
	
	public Logs(String method, String params, Date invokationDate) {
		super();
		this.method = method;
		this.params = params;
		this.invokationDate = invokationDate;
	}


	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public Date getInvokationDate() {
		return invokationDate;
	}

	public void setInvokationDate(Date invokationDate) {
		this.invokationDate = invokationDate;
	}

	@Override
	public String toString() {
		return "Logs [id=" + id + ", method=" + method + ", params=" + params + ", invokationDate=" + invokationDate
				+ "]";
	}
	
}
