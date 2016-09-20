package com.ivk23.lms.service;

import java.util.List;

import com.ivk23.lms.commons.interfaces.IRole;
import com.ivk23.lms.commons.interfaces.IStatus;

public interface ReferenceDataService {
	
	public List<IRole> getAllRoles();
	
	public List<IStatus> getAllStatuses();
	
	public IRole getRoleById(Long id);
	
	public IStatus getStatusById(Long id);

}
