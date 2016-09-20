package com.ivk23.lms.dao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ivk23.lms.commons.interfaces.IEmployee;

@Entity
public class Employee implements IEmployee, Serializable {

	private static final long serialVersionUID = 7317689336646340448L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "birth_date", nullable = false)
	private Date birthDate;

	@Column(name = "emp_level", nullable = false)
	private String level;

	@Column(name = "prim_skill", nullable = false)
	private String primarySkill;

	@Column(name = "is_manager", nullable = false)
	private char manager; // Y or N

	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, Date birthDate, String level, 
			String primarySkill, char manager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.level = level;
		this.primarySkill = primarySkill;
		this.manager = manager;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	@Override
	public char getManager() {
		return manager;
	}

	public void setManager(char manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", level=" + level + ", primarySkill=" + primarySkill + ", manager=" + manager + "]";
	}

}
