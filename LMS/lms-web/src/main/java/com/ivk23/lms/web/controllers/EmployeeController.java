package com.ivk23.lms.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivk23.lms.commons.interfaces.IEmployee;
import com.ivk23.lms.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
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
	
	

}
