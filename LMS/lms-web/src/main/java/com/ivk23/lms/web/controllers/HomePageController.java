package com.ivk23.lms.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.context.ILazyContextVariable;
import org.thymeleaf.context.LazyContextVariable;

import com.ivk23.lms.commons.interfaces.IMentorshipProgram;
import com.ivk23.lms.service.MentorshipProgramService;
import com.ivk23.lms.web.utils.UIConstants;

@Controller
public class HomePageController {

	@Autowired
	private MentorshipProgramService mentProgramService;
	
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute(UIConstants.LAYOUT_VIEW, UIConstants.HOME_PAGE_CONTENT_VIEW_NAME);
		return "index";
	}
	
	@GetMapping(value = "/sysapi")
	public String sysapi(Model model) {
		model.addAttribute(UIConstants.LAYOUT_VIEW, UIConstants.SYSAPI_PAGE_CONTENT_VIEW_NAME);
		return "index";
	}
	
	@ModelAttribute("activePrograms")
	public ILazyContextVariable<List<IMentorshipProgram>> addActivePrograms() {
		return new LazyContextVariable<List<IMentorshipProgram>>() {

			@Override
			public List<IMentorshipProgram> loadValue() {
				return mentProgramService.getActivePrograms(true);
			}
		};
	}

}
