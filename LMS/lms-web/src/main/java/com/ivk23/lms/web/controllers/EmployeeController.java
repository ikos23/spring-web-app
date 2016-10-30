package com.ivk23.lms.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.service.EmployeeService;
import com.ivk23.lms.web.utils.UIConstants;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String employees(Model model) {
		model.addAttribute(UIConstants.LAYOUT_VIEW, UIConstants.EMPLOYEES_PAGE_CONTENT_VIEW_NAME);
		return "index";
	}
	
	@ModelAttribute("autoCompleteSelectHandler")
	public String addAutocompleteSelectHandler() {
		return "handleEmployeeSearchAutocompleteSelect";
	}
	
	@ModelAttribute("autoCompleteFocusHandler")
	public String addAutocompleteFocusHandler() {
		return "handleEmployeeSearchAutocompleteFocus";
	}
	
	@RequestMapping(value = "/employees/json", method = GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<IEmployee> getAllEmployeeInJson() {
		return employeeService.findAllEmployees();
	}
	
	@RequestMapping(value = "/employees/xml", method = GET, produces = { MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<IEmployee> getAllEmployeeInXml() {
		return employeeService.findAllEmployees();
	}
	
	@RequestMapping(value = "/edit", method = GET)
	public String edit(Model model) {
		List<IEmployee> employees = employeeService.findAllEmployees();
		
		model.addAttribute("employees", employees);
		
		return "tl/editPage";
	}
	
	@RequestMapping(value = "/updateEmpl", method = POST)
	public String updateUser(@RequestParam("eID") String id, @RequestParam("lastName") String lastName,
			@RequestParam("primarySkill") String skill, @RequestParam("level") String level, 
				@RequestParam("manager") String manager) {
		
		employeeService.updateEmployeeData(Long.valueOf(id), lastName, skill, level, manager);
		
		return "redirect:/employees";
		
	}
	
	@RequestMapping(value = "/selectEmpl", method = POST, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE } )
	@ResponseBody
	public List<IEmployee> selectEmployee(@RequestParam("namePrefix") String lastNamePrefix) {
		List<IEmployee> employeesByLastName = employeeService.findEmployeesByLastNameStartingWith(lastNamePrefix);
		 
		return employeesByLastName;
	}

}
