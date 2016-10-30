package com.ivk23.lms.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ivk23.lms.web.utils.UIConstants;

@Controller
public class AboutPageController {
	
	@GetMapping("/about")
	public String about() {
		return "index";
	}
	
	@ModelAttribute(UIConstants.LAYOUT_VIEW)
	public String setView() {
		return UIConstants.ABOUT_PAGE_CONTENT_VIEW_NAME;
	}
	
}
