package com.ivk23.lms.commons.enums;

public enum ReferenceDataType {
	
	STATUS("statuses"), ROLE("roles");
	
	private String type;

	private ReferenceDataType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
