package com.ivk23.lms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;
import com.ivk23.lms.dao.domain.MentorshipProgram;
import com.ivk23.lms.dao.domain.Phase;
import com.ivk23.lms.dao.repository.MentorshipProgramRepository;
import com.ivk23.lms.dao.repository.PhaseRepository;
import com.ivk23.lms.service.MentorshipProgramService;

@Service
@Transactional
public class MentorshipProgramServiceImpl implements MentorshipProgramService {

	@Autowired // optional from Spring 4.x.y :)
	private final MentorshipProgramRepository mtRepository;

	@Autowired
	private final PhaseRepository phaseRepository;

	public MentorshipProgramServiceImpl(MentorshipProgramRepository mtRepository, PhaseRepository phaseRepository) {
		super();
		this.mtRepository = mtRepository;
		this.phaseRepository = phaseRepository;
	}

	@Override
	public IMentorshipProgram createNewProgram(IMentorshipProgram program) {
		final IMentorshipProgram entity = new MentorshipProgram(program.getName(), program.getOffice(), program.getStartDate(),
				program.getEndDate());

		final IMentorshipProgram savedEntity = mtRepository.save(entity);
		
		return savedEntity;
	}

	@Override
	public List<IMentorshipProgram> findAllPrograms() {
		List<IMentorshipProgram> all = mtRepository.findAll();
		return all;
	}

	@Override
	public IPhase createNewPhase(IPhase phase) {
		IMentorshipProgram mentorshipProgram = mtRepository.findById(phase.getMentorshipProgram().getId());

		IPhase entity = new Phase(phase.getName(), (MentorshipProgram) mentorshipProgram, phase.getStartDate(),
				phase.getEndDate());
		return phaseRepository.save(entity);
	}

	@Override
	public List<IPhase> findAllPhases() {
		return phaseRepository.findAll();
	}
	
	@Override
	public List<IMentorshipProgram> getActivePrograms(boolean includePhases) {
		// if program's endDate >= today - program is still active
		List<IMentorshipProgram> active = mtRepository.findByEndDateGreaterThanEqualOrderByStartDateDesc(new Date());
		
		// remember - there is a special room in hell for those who make calls to DB within loop !
		active.forEach(el -> { 
			List<IPhase> phases = phaseRepository.findByMentorshipProgramId(el.getId());
			el.setPhases(phases);
		});
		
		return active;
	}
	
	@Override
	public List<IPhase> getPhasesForProgram(Long id) {
		return phaseRepository.findByMentorshipProgramId(id);
	}
	
	@Override
	public void deletePhaseById(Long id) {
		IPhase phase = phaseRepository.findById(id);
		phaseRepository.delete(phase);
	}

}
