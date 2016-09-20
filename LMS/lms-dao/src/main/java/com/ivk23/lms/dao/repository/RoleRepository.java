package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.IRole;
import com.ivk23.lms.dao.domain.Role;

public interface RoleRepository extends Repository<Role, Long> {
	
	public List<IRole> findAll();
	
	public IRole findById(Long id);
	
	public IRole findByName(String name);

}
