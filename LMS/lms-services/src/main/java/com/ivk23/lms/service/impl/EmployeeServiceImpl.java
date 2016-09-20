package com.ivk23.lms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.dao.domain.Employee;
import com.ivk23.lms.dao.repository.EmployeeRepository;
import com.ivk23.lms.service.EmployeeService;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<IEmployee> findAllEmployees() {
		
		return employeeRepository.findAll();
		
	}

	@Override
	public IEmployee addEmployee(IEmployee employee) {
		Employee entity = new Employee(employee.getFirstName(), 
				employee.getLastName(), employee.getBirthDate(), employee.getLevel(), 
					employee.getPrimarySkill(), employee.getManager());
		return employeeRepository.save(entity);
	}
	
	@Override
	public List<IEmployee> findEmployeesByLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

}
