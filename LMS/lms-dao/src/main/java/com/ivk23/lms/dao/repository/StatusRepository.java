package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.IStatus;
import com.ivk23.lms.dao.domain.Status;

public interface StatusRepository extends Repository<Status, Long> {
	
	
	public List<IStatus> findAll();
	
	public IStatus findById(Long id);
	
	public IStatus findByName(String name);

}
