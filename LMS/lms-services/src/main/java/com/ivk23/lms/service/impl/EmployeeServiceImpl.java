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
		IEmployee entity = new Employee(employee.getFirstName(), 
				employee.getLastName(), employee.getBirthDate(), employee.getLevel(), 
					employee.getPrimarySkill(), employee.getManager());
		return employeeRepository.save(entity);
	}
	
	@Override
	public List<IEmployee> findEmployeesByLastNameStartingWith(String lastName) {
		return employeeRepository.findByLastNameStartingWithIgnoreCase(lastName);
	}

	@Override
	public IEmployee updateEmployeeData(Long id, String lastName, String primarySkill, String level, String manager) {
		Employee toBeUpdated = (Employee)employeeRepository.findById(id);
		
		if (!toBeUpdated.getLastName().equals(lastName)) {
			toBeUpdated.setLastName(lastName);
		}
		
		if (!toBeUpdated.getPrimarySkill().equals(primarySkill)) {
			toBeUpdated.setPrimarySkill(primarySkill);
		}
		
		if (!toBeUpdated.getLevel().equals(level)) {
			toBeUpdated.setLevel(level);
		}
		
		if (toBeUpdated.getManager() != manager.charAt(0)) {
			toBeUpdated.setManager(manager.charAt(0));
		}
		
		return employeeRepository.save(toBeUpdated);
	}

}
