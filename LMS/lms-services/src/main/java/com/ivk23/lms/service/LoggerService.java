package com.ivk23.lms.service;

import java.util.List;

import com.ivk23.lms.commons.interfaces.ILogs;

public interface LoggerService {
	
	ILogs createLog(ILogs log);
	
	List<ILogs> getAll();

}
