package com.ivk23.lms.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivk23.lms.commons.enums.ReferenceDataType;
import com.ivk23.lms.commons.interfaces.IReferenceData;
import com.ivk23.lms.commons.interfaces.IRole;
import com.ivk23.lms.commons.interfaces.IStatus;
import com.ivk23.lms.service.ReferenceDataService;

@Controller
public class ReferenceDataController {

	@Autowired
	private ReferenceDataService refDataService;

	@RequestMapping(value = "/refdata/all/json/{type}", method = GET, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<? extends IReferenceData> getRefDataInJson(@PathVariable(value = "type") String type) {
		return getRefData(type);
	}

	@RequestMapping(value = "/refdata/all/xml/{type}", method = GET, produces = { MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<? extends IReferenceData> getRefDataInXml(@PathVariable(value = "type") String type) {
		return getRefData(type);
	}

	@RequestMapping(value = "/refdata/all/html/{type}", method = GET, produces = { MediaType.TEXT_HTML_VALUE })
	@ResponseBody
	public String getRefDataInHtml(@PathVariable(value = "type") String type) {
		StringBuilder content = new StringBuilder();
		content.append("<html>");
		content.append("<head><title>Reference Data</title></head>");
		content.append("<body style=\"font-family : Verdana;\">");
		content.append("<h4 style=\"color : blue;\">Supported <i>" + type + "</i> are:</h4>");
		content.append("<ul style=\"border: 1px solid #b9b9b9;\">");

		List<? extends IReferenceData> refData = getRefData(type);
		for (IReferenceData item : refData) {
			if (ReferenceDataType.STATUS.getType().equals(type)) {
				IStatus i = (IStatus) item;
				content.append("<li>");
				content.append("<strong>id:</strong> " + i.getId() + " , <strong>name:</strong> " + i.getName());
				content.append("</li>");
			} else if (ReferenceDataType.ROLE.getType().equals(type)) {
				IRole i = (IRole) item;
				content.append("<li>");
				content.append("<strong>id:</strong> " + i.getId() + " , <strong>name:</strong> " + i.getName());
				content.append("</li>");
			} else {
				content.append("<li>No data</li>");
				break;
			}
		}

		content.append("</ul>");
		content.append("</body>");
		content.append("</html>");

		return content.toString();
	}

	private List<? extends IReferenceData> getRefData(String type) {

		if (ReferenceDataType.STATUS.getType().equals(type)) {
			return refDataService.getAllStatuses();
		} else if (ReferenceDataType.ROLE.getType().equals(type)) {
			return refDataService.getAllRoles();
		} else { // no more ref data supported
			return new ArrayList<>();
		}

	}

}
