package com.ivk23.lms.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.ILazyContextVariable;
import org.thymeleaf.context.LazyContextVariable;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.commons.interfaces.IPhase;
import com.ivk23.lms.commons.interfaces.IRole;
import com.ivk23.lms.service.MentorshipProgramService;
import com.ivk23.lms.service.ReferenceDataService;
import com.ivk23.lms.web.ui.models.MentorshipProgram;
import com.ivk23.lms.web.ui.models.Phase;
import com.ivk23.lms.web.utils.ActionResponse;
import com.ivk23.lms.web.utils.Error;
import com.ivk23.lms.web.utils.UIConstants;
import com.ivk23.lms.web.validators.CustomValidator;

@Controller
public class MntProgramPageController {

	@Autowired
	private MentorshipProgramService mentProgramService;
	
	@Autowired
	private ReferenceDataService refDataService;

	@Autowired
	private CustomValidator customValidator;
	
	@ModelAttribute(UIConstants.LAYOUT_VIEW)
	public String setView() {
		return UIConstants.PROGRAMS_PAGE_CONTENT_VIEW_NAME;
	}
	
	@ModelAttribute("autoCompleteSelectHandler")
	public String addAutocompleteSelectHandler() {
		return "editPhaseEmployeeAutoCompleteSelect";
	}
	
	@ModelAttribute("autoCompleteFocusHandler")
	public String addAutocompleteFocusHandler() {
		return "editPhaseEmployeeAutoCompleteFocus";
	}
	
	@ModelAttribute("roles")
	public ILazyContextVariable<List<IRole>> addRoles() {
		return new LazyContextVariable<List<IRole>>() {
			@Override
			public List<IRole> loadValue() {
				return refDataService.getAllRoles();
			}
		};
	}
	
	@ModelAttribute("phases")
	public ILazyContextVariable<List<IPhase>> addPhases() {
		return new LazyContextVariable<List<IPhase>>() {
			@Override
			public List<IPhase> loadValue() {
				return mentProgramService.findAllPhases();
			}
		};
	}

	@GetMapping("/programs")
	public String programs(Model model) {
		return "index";
	}

	@RequestMapping(value = "/mtprograms/all/json", method = GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IMentorshipProgram> getAllMentorshipProgramInJson() {
		return mentProgramService.findAllPrograms();
	}
	
	@RequestMapping(value = "/get/active/programs/json", method = GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IMentorshipProgram> getActiveMentorshipProgramsInJson() {
		return mentProgramService.getActivePrograms(false);
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
		return mentProgramService.getActivePrograms(true);
	}

	@PostMapping(value = "/mtprograms/create", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public ActionResponse createNewProgram(@RequestBody @Valid MentorshipProgram program, Errors errors) {
		final ActionResponse response = grabAllErrorsAndValidate(errors, program.getStartDate(), program.getEndDate());

		if (response.hasErrors()) {
			return response.withCode(HttpStatus.BAD_REQUEST.value()).withMessage("Form contains validation errors.");
		} else {
			mentProgramService.createNewProgram(program);
			return response.withCode(HttpStatus.OK.value())
					.withMessage("New program [" + program.getName() + "] created successfully.");
		}

	}

	@RequestMapping(value = "/mphase/create", method = POST, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public ActionResponse createNewPhase(@RequestBody @Valid Phase phase, Errors errors) {
		final ActionResponse response = grabAllErrorsAndValidate(errors, phase.getStartDate(), phase.getEndDate());

		if (response.hasErrors()) {
			return response.withCode(HttpStatus.BAD_REQUEST.value()).withMessage("Form contains validation errors.");
		} else {
			mentProgramService.createNewPhase(phase);
			return response.withCode(HttpStatus.OK.value()).withMessage("New phase created successfully.");
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
