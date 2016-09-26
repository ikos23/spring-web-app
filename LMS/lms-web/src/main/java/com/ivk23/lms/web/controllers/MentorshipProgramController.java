package com.ivk23.lms.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;
import com.ivk23.lms.service.MentorshipProgramService;
import com.ivk23.lms.service.ReferenceDataService;
import com.ivk23.lms.web.utils.ActionResponse;
import com.ivk23.lms.web.utils.Error;
import com.ivk23.lms.web.validators.CustomValidator;

@Controller
@SuppressWarnings("unused")
public class MentorshipProgramController {

	private static class MentorshipProgram implements IMentorshipProgram {

		@NotNull(message = "Program name can not be empty")
		@Size(min = 2, max = 20, message = "Program name length must be between 2 and 20 characters")
		private String name;

		@NotNull(message = "Office field can not be empty")
		@Size(min = 2, max = 15, message = "Office field length must be between 5 and 15 characters")
		private String office;

		@NotNull(message = "Program Start Date can not be empty")
		private Date startDate;

		@NotNull(message = "Program End Date can not be empty")
		private Date endDate;

		public MentorshipProgram() {
			super();
		}

		public String getName() {
			return name;
		}

		public String getOffice() {
			return office;
		}

		public Date getStartDate() {
			return this.startDate;
		}

		public Date getEndDate() {
			return this.endDate;
		}

		@Override
		public Long getId() {
			return 0L;
		}

		@Override
		public String toString() {
			return "MentorshipProgram [name=" + name + ", office=" + office + ", startDate=" + startDate
					+ ", endDate=" + endDate + "]";
		}

		@Override
		public List<IPhase> getPhases() {
			return new ArrayList<>();
		}

		@Override
		public void setPhases(List<IPhase> l) {
			// :)
		}

		@Override
		public String getCreatedBy() {
			return null;
		}

		@Override
		public Date getCreationDate() {
			return null;
		}

	}

	private static class Phase implements IPhase {

		@NotNull(message = "Phase name can not be empty")
		@Size(min = 2, max = 25, message = "Phase name length must be between 2 and 25 characters")
		private String name;

		@NotNull(message = "Phase Start Date can not be empty")
		private Date startDate;

		@NotNull(message = "Phase End Date can not be empty")
		private Date endDate;

		@NotNull(message = "Program is not selected")
		private Long mentorshipProgramID;

		@Override
		public Long getId() { // because this is not a perfect life >_<
			return 0L;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public Long getMentorshipProgramID() {
			return mentorshipProgramID;
		}

		@Override
		public IMentorshipProgram getMentorshipProgram() {
			return new IMentorshipProgram() { // why not ?)

				@Override
				public Date getStartDate() {
					return null;
				}

				@Override
				public String getOffice() {
					return null;
				}

				@Override
				public String getName() {
					return null;
				}

				@Override
				public Long getId() {
					return mentorshipProgramID;
				}

				@Override
				public Date getEndDate() {
					return null;
				}

				@Override
				public List<IPhase> getPhases() {
					return null;
				}

				@Override
				public void setPhases(List<IPhase> l) {
				}

				@Override
				public String getCreatedBy() {
					return null;
				}

				@Override
				public Date getCreationDate() {
					return null;
				}

			};
		}

		@Override
		public Date getStartDate() {
			return startDate;
		}

		@Override
		public Date getEndDate() {
			return endDate;
		}

		@Override
		public String toString() {
			return "Phase [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
					+ ", mentorshipProgramID=" + mentorshipProgramID + "]";
		}

	}

	@Autowired
	private MentorshipProgramService mentProgramService;

	@Autowired
	private ReferenceDataService refDataService;

	@Autowired
	private CustomValidator customValidator;

	@RequestMapping(value = "/mtprograms/all/json", method = GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IMentorshipProgram> getAllMentorshipProgramInJson() {
		return mentProgramService.findAllPrograms();
	}

	@RequestMapping(value = "/mtprograms/all/xml", method = GET, produces = { MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<IMentorshipProgram> getAllMentorshipProgramInXml() {
		return mentProgramService.findAllPrograms();
	}

	@RequestMapping(value = "/phases/all/json", method = GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IPhase> getAllPhasesInJson() {
		return mentProgramService.findAllPhases();
	}

	@RequestMapping(value = "/mtprograms/active/json", method = GET, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IMentorshipProgram> getActiveProgramsInJson() {
		return mentProgramService.getActiveProgramsWithPhases();
	}

	@RequestMapping(value = "/mtprograms/create", method = POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public ActionResponse createNewProgram(@RequestBody @Valid MentorshipProgram program, Errors errors) {
		final ActionResponse response = grabAllErrorsAndValidate(errors, program.getStartDate(), program.getEndDate());

		if (response.hasErrors()) {
			return response.withCode(HttpStatus.BAD_REQUEST.value()).withMessage("Form contains validation errors");
		} else {	
			final IMentorshipProgram newProgram = mentProgramService.createNewProgram(program);
			return response.withCode(HttpStatus.OK.value()).withMessage("Created successfully");
		}

	}

	@RequestMapping(value = "/mphase/create", method = POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public ActionResponse createNewPhase(@RequestBody @Valid Phase phase, Errors errors) {
		final ActionResponse response = grabAllErrorsAndValidate(errors, phase.getStartDate(), phase.getEndDate());
		
		if (response.hasErrors()) {
			return response.withCode(HttpStatus.BAD_REQUEST.value()).withMessage("Form contains validation errors");
		} else {
			IPhase newPhase = mentProgramService.createNewPhase(phase);
			return response.withCode(HttpStatus.OK.value()).withMessage("Created successfully");
		}

	}

	@RequestMapping(value = "/del/phase/{id}", method = DELETE)
	@ResponseBody
	public ActionResponse deletePhaseById(@PathVariable("id") Long phaseId) {
		mentProgramService.deletePhaseById(phaseId);

		return new ActionResponse().withCode(HttpStatus.ACCEPTED.value())
				.withMessage("Phase #" + phaseId + " Successfully Deleted");
	}
	
	// just to avoid duplication
	private ActionResponse grabAllErrorsAndValidate(Errors errors, Date start, Date end) {
		final ActionResponse response = new ActionResponse();
		
		if (start == null) {
			response.addError(new Error("Start Date value provided is not valid"));
		}
		
		if (end == null) {
			response.addError(new Error("End Date value provided is not valid"));
		}

		// grab general errors
		if (errors.hasErrors()) {
			errors.getAllErrors().forEach(e -> {
				response.addError(new Error(e.getDefaultMessage()));
			});
		}

		// additionally validate that startDate < endDate
		if (start != null && end != null) {
			Optional<Error> validateDateRange = customValidator.validateDateRange(start, end);

			if (validateDateRange.isPresent()) {
				response.addError(validateDateRange.get());
			}
		}

		return response;
	}

}
