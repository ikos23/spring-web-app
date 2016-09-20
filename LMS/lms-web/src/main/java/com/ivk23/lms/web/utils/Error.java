package com.ivk23.lms.web.utils;

public class Error {

	private String description;

	public Error() {
		super();
	}

	public Error(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Error [description=" + description + "]";
	}
	
}
