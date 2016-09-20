package com.ivk23.lms.service;

import java.util.List;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;

public interface MentorshipProgramService {
	
	public IMentorshipProgram createNewProgram(IMentorshipProgram mtProgram);
	
	public IPhase createNewPhase(IPhase phase);
	
	public void deletePhaseById(Long id);
	
	public List<IMentorshipProgram> findAllPrograms();
	
	public List<IPhase> findAllPhases();

	public List<IMentorshipProgram> getActiveProgramsWithPhases();

	public List<IPhase> getPhasesForProgram(Long id);

}
