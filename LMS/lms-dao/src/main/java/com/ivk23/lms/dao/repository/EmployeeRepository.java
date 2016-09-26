package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.dao.domain.Employee;

public interface EmployeeRepository extends Repository<Employee, Long> {
	
	public List<IEmployee> findAll();
	
	public List<IEmployee> findByLastNameStartingWith(String lastName);
	
	public List<IEmployee> findByPrimarySkill(String primarySkill);
	
	public IEmployee save(IEmployee employee);
	
	public void delete(IEmployee employee);
	
	public IEmployee findById(Long id);

}
