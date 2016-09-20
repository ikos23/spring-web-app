package com.ivk23.lms.service;

import java.util.List;

import com.ivk23.lms.commons.interfaces.IEmployee;

public interface EmployeeService {
	
	public List<IEmployee> findAllEmployees();
	
	public IEmployee addEmployee(IEmployee employee);

	public List<IEmployee> findEmployeesByLastName(String lastName);

}
