package com.ivk23.lms.commons.interfaces;

import java.util.Date;

public interface IEmployee {

	public Long getId();

	public String getFirstName();

	public String getLastName();

	public Date getBirthDate();

	public String getLevel();

	public String getPrimarySkill();

	public char getManager();

}
