package com.ivk23.lms.web.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.commons.interfaces.IGroup;
import com.ivk23.lms.commons.interfaces.IPhasePartisipAssignments;
import com.ivk23.lms.commons.utils.DateUtils;
import com.ivk23.lms.service.ParticipantsAndGroupsService;
import com.ivk23.lms.web.ui.models.ParticipantAssignment;
import com.ivk23.lms.web.utils.ActionResponse;
import com.ivk23.lms.web.utils.Error;

@Controller
public class PhaseConfigController {

	@Autowired
	private ParticipantsAndGroupsService partService;

	@RequestMapping(value = "/assignEmployee", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public IPhasePartisipAssignments assignEmployee(@RequestParam("employeeID") String emplID,
			@RequestParam("roleID") String roleID, @RequestParam("phaseID") String phaseID) {
		ParticipantAssignment asgn = new ParticipantAssignment();

		asgn.setEmployeeID(Long.valueOf(emplID));
		asgn.setRoleID(Long.valueOf(roleID));
		asgn.setPhaseID(Long.valueOf(phaseID));

		return partService.saveAssignment(asgn);
	}

	@RequestMapping(value = "/get/allAssignments/xml", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<IPhasePartisipAssignments> getAllAssignmentsXml() {
		return partService.findAll();
	}

	@RequestMapping(value = "/loadAvailableMentors", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IEmployee> availableMentors() {
		return partService.findAvailableMentors();
	}

	@RequestMapping(value = "/createGroup", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public ActionResponse createGroup(@RequestParam("menteeId") String menteeId,
			@RequestParam("mentorId") String mentorId, @RequestParam("plannedStart") String plannedStart,
			@RequestParam("plannedEnd") String plannedEnd) throws NumberFormatException, ParseException {

		try { 
			partService.createGroup(Long.valueOf(mentorId), Long.valueOf(menteeId), DateUtils.convert(plannedStart),
				DateUtils.convert(plannedEnd), null, null);
			return new ActionResponse().withCode(200).withMessage("New group created successfully.");
		} catch (Exception e) {
			return new ActionResponse().withCode(409).addError(new Error("Group was not created. Error " +  e.getMessage()));
		}
		
	}
	
	@RequestMapping(value = "/get/all/groups/xml", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<IGroup> getAllGroupsXml() {
		return partService.getAllGroups();
	}
	
	@RequestMapping(value = "/get/all/mentors/xml", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<IEmployee> getAllMentorsXml() {
		return partService.getAllMentorsWithMenteeMoreThan(2);
	}
	
	@RequestMapping(value = "/get/menteenomentor/{office}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<IEmployee> getAllMenteeWithoutMentorInLocationXml(@PathVariable("office") String office) {
		return partService.menteeWithNoMentorsInLocation(office);
	}
	
	@RequestMapping(value = "/get/by/duration", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<MenteeWithDuration> getAllMenteeByProgramsDurationXml() {
		final List<MenteeWithDuration> list = new ArrayList<>();
		
		partService.menteeGroupedByProgramsDuration().forEach((el) -> {
			list.add(new MenteeWithDuration(el.getLeft().getId(), el.getLeft().getFirstName() + " " + el.getLeft().getLastName(), el.getRight()));
		});
		
		return list;
	}
	
	private static class MenteeWithDuration {

		private Long menteeID;
		private String fullName;
		private Long totalNumberOfDays;

		public MenteeWithDuration(Long menteeID, String fullName, Long totalNumberOfDays) {
			super();
			this.menteeID = menteeID;
			this.fullName = fullName;
			this.totalNumberOfDays = totalNumberOfDays;
		}

		@SuppressWarnings("unused")
		public Long getMenteeID() {
			return menteeID;
		}

		@SuppressWarnings("unused")
		public String getFullName() {
			return fullName;
		}

		@SuppressWarnings("unused")
		public Long getTotalNumberOfDays() {
			return totalNumberOfDays;
		}
	}

}
