package com.ivk23.lms.service;

import java.util.Date;
import java.util.List;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.commons.interfaces.IGroup;
import com.ivk23.lms.commons.interfaces.IPhasePartisipAssignments;
import com.ivk23.lms.commons.utils.Pair;

public interface ParticipantsAndGroupsService {

	IPhasePartisipAssignments saveAssignment(IPhasePartisipAssignments assignm);

	List<IPhasePartisipAssignments> findAll();

	IGroup createGroup(final Long mentorID, final Long menteeID, final Date plannedStart, final Date plannedEnd,
			final Date actualStart, final Date actualEnd);
	
	List<IEmployee> findAvailableMentors();
	
	List<IGroup> getAllGroups();

	List<IEmployee> getAllMentorsWithMenteeMoreThan(int num);

	List<IEmployee> menteeWithNoMentorsInLocation(String office);

	List<Pair<IEmployee, Long>> menteeGroupedByProgramsDuration();

}
