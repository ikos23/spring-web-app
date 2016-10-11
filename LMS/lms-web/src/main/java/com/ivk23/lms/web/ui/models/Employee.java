package com.ivk23.lms.web.ui.models;

import java.util.Date;

import com.ivk23.lms.commons.interfaces.IEmployee;

public class Employee implements IEmployee {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String level;
	private String primarySkill;
	private String manager;

	public Employee setId(Long id) {
		this.id = id;
		return this;
	}

	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Employee setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Employee setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public Employee setLevel(String level) {
		this.level = level;
		return this;
	}

	public Employee setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
		return this;
	}

	public Employee setManager(String manager) {
		this.manager = manager;
		return this;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public Date getBirthDate() {
		return this.birthDate;
	}

	@Override
	public String getLevel() {
		return this.level;
	}

	@Override
	public String getPrimarySkill() {
		return this.primarySkill;
	}

	@Override
	public char getManager() {
		return this.manager.toUpperCase().charAt(0);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", level=" + level + ", primarySkill=" + primarySkill + ", manager=" + manager + "]";
	}

}
