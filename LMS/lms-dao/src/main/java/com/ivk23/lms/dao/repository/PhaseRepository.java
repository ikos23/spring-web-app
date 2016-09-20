package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.ivk23.lms.commons.interfaces.IPhase;
import com.ivk23.lms.dao.domain.Phase;

public interface PhaseRepository extends Repository<Phase, Long> {
	
	public IPhase save(IPhase entity);
	
	public void delete(IPhase entity);
	
	public List<IPhase> findAll();
	
	public IPhase findById(Long id);
	
	@Query("SELECT p FROM Phase p WHERE p.mentorshipProgram.id = :id")
	public List<IPhase> findByMentorshipProgramId(@Param("id") Long mpID);

}
