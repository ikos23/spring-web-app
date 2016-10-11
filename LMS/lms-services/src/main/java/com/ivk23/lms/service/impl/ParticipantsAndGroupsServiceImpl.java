package com.ivk23.lms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.commons.interfaces.IGroup;
import com.ivk23.lms.commons.interfaces.IPhasePartisipAssignments;
import com.ivk23.lms.commons.utils.Pair;
import com.ivk23.lms.dao.domain.Employee;
import com.ivk23.lms.dao.domain.Group;
import com.ivk23.lms.dao.domain.Phase;
import com.ivk23.lms.dao.domain.PhasePartisipAssignments;
import com.ivk23.lms.dao.domain.Role;
import com.ivk23.lms.dao.domain.Status;
import com.ivk23.lms.dao.repository.EmployeeRepository;
import com.ivk23.lms.dao.repository.GroupCustomRepository;
import com.ivk23.lms.dao.repository.GroupRepository;
import com.ivk23.lms.dao.repository.ParticipantAssignmentRepository;
import com.ivk23.lms.dao.repository.PhaseRepository;
import com.ivk23.lms.dao.repository.RoleRepository;
import com.ivk23.lms.dao.repository.StatusRepository;
import com.ivk23.lms.service.ParticipantsAndGroupsService;

@Service
@Transactional
public class ParticipantsAndGroupsServiceImpl implements ParticipantsAndGroupsService {

	@Autowired
	private ParticipantAssignmentRepository participantAssignmentRepo;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PhaseRepository phaseRepository;

	@Autowired
	private EmployeeRepository emplRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private GroupCustomRepository groupCustomRepo;

	@Override
	public IPhasePartisipAssignments saveAssignment(IPhasePartisipAssignments assignm) {
		PhasePartisipAssignments entity = new PhasePartisipAssignments();

		entity.setEmployee((Employee) emplRepository.findById(assignm.getEmployee().getId()));
		entity.setRole((Role) roleRepository.findById(assignm.getRole().getId()));
		entity.setPhase((Phase) phaseRepository.findById(assignm.getPhase().getId()));

		return participantAssignmentRepo.save(entity);
	}

	@Override
	public List<IPhasePartisipAssignments> findAll() {
		return participantAssignmentRepo.findAll();
	}

	@Override
	public IGroup createGroup(Long mentorID, Long menteeID, Date plannedStart, Date plannedEnd, Date actualStart,
			Date actualEnd) {
		Group entity = new Group((Employee) emplRepository.findById(mentorID),
				(Employee) emplRepository.findById(menteeID), plannedStart, plannedEnd, actualStart, actualEnd,
				(Status) statusRepository.findById(1L));

		return groupRepository.save(entity);
	}

	@Override
	public List<IEmployee> findAvailableMentors() {
		List<IPhasePartisipAssignments> byRole = participantAssignmentRepo.findByRole();

		return byRole.stream().map(new Function<IPhasePartisipAssignments, IEmployee>() {

			@Override
			public IEmployee apply(IPhasePartisipAssignments t) {
				return t.getEmployee();
			}
		}).collect(Collectors.toList());
	}

	@Override
	public List<IGroup> getAllGroups() {
		return groupRepository.findAll();
	}
	
	@Override
	public List<IEmployee> getAllMentorsWithMenteeMoreThan(int num) {
		return groupCustomRepo.mentorsWithSeveralMentee(num);
	}
	
	@Override
	public List<IEmployee> menteeWithNoMentorsInLocation(String office) {
		return groupCustomRepo.menteeWithoutMentorInOffice(office);
	}
	
	@Override
	public List<Pair<IEmployee, Long>> menteeGroupedByProgramsDuration() {
		return groupCustomRepo.menteesGrouppedByDuration();
	}

}
