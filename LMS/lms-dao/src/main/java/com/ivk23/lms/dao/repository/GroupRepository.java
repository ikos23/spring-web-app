package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.IGroup;
import com.ivk23.lms.dao.domain.Group;

public interface GroupRepository extends Repository<Group, Long> {

	IGroup save(IGroup entity);

	List<IGroup> findAll();
	
	IGroup findById(Long id);

}
