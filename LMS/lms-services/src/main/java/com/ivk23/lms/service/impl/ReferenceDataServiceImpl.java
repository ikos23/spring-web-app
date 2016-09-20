package com.ivk23.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivk23.lms.commons.interfaces.IRole;
import com.ivk23.lms.commons.interfaces.IStatus;
import com.ivk23.lms.dao.repository.RoleRepository;
import com.ivk23.lms.dao.repository.StatusRepository;
import com.ivk23.lms.service.ReferenceDataService;

@Service
@Transactional
public class ReferenceDataServiceImpl implements ReferenceDataService {
	
	@Autowired
	private final StatusRepository statusRepository;

	@Autowired
	private final RoleRepository roleRepository;
	
	public ReferenceDataServiceImpl(StatusRepository statusRepository, RoleRepository roleRepository) {
		super();
		this.statusRepository = statusRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public List<IRole> getAllRoles() {
		return this.roleRepository.findAll();
	}

	@Override
	public List<IStatus> getAllStatuses() {
		return this.statusRepository.findAll();
	}

	@Override
	public IRole getRoleById(Long id) {
		return this.roleRepository.findById(id);
	}

	@Override
	public IStatus getStatusById(Long id) {
		return this.statusRepository.findById(id);
	}

}
