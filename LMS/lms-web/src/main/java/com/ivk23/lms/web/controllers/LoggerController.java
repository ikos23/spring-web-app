package com.ivk23.lms.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivk23.lms.commons.interfaces.ILogs;
import com.ivk23.lms.service.LoggerService;

@Controller
public class LoggerController {

	@Autowired
	private LoggerService loggerService;
	
	@RequestMapping(value = "/logs/all/xml", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<ILogs> getAllLogsInXml() {
		return loggerService.getAll();
	}
	
}
