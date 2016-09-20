package com.ivk23.lms.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.dao.domain.MentorshipProgram;

public interface MentorshipProgramRepository extends Repository<MentorshipProgram, Long> {
	
	public IMentorshipProgram save(IMentorshipProgram entity);
	
	public Long count();
	
	public void delete(IMentorshipProgram entity);
	
	public List<IMentorshipProgram> findAll();
	
	public IMentorshipProgram findById(Long id);
	
	/**
	 * Perfect name. That's Spring Data. Love it !
	 * 
	 * <p>This method searches for programs whose <code>endDate >= input param</code>
	 * provided; order result list by <code>startDate</code> DESC and returns it.</p>
	 */
	public List<IMentorshipProgram> findByEndDateGreaterThanEqualOrderByStartDateDesc(Date date);

}
