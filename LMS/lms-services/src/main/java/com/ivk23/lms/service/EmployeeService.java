package com.ivk23.lms.service;

import java.util.List;

import com.ivk23.lms.commons.interfaces.IEmployee;

public interface EmployeeService {
	
	public List<IEmployee> findAllEmployees();
	
	public IEmployee addEmployee(IEmployee employee);

	public List<IEmployee> findEmployeesByLastNameStartingWith(String lastName);
	
	/**
	 * <ul>
	 * <li>LastName can be updated.</li>
	 * <li>Level can be updated.</li>
	 * <li>Primary Skill can be updated.</li>
	 * <li>Is Manager - can be updated.</li>
	 * </ul>
	 * 
	 * Updates for all other fields are forbidden !
	 */
	public IEmployee updateEmployeeData(Long id, String lastName, 
			String primarySkill, String level, String manager);

}
