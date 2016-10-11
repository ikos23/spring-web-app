package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.IPhasePartisipAssignments;
import com.ivk23.lms.dao.domain.PhasePartisipAssignments;

public interface ParticipantAssignmentRepository extends Repository<PhasePartisipAssignments, Long> {
	
	IPhasePartisipAssignments save(IPhasePartisipAssignments entity);
	
	List<IPhasePartisipAssignments> findAll();
	
	@Query("SELECT a FROM PhasePartisipAssignments a WHERE a.role.id=1")
	List<IPhasePartisipAssignments> findByRole();

}
