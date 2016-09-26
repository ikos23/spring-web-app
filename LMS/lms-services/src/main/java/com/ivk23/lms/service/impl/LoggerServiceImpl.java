package com.ivk23.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivk23.lms.commons.interfaces.ILogs;
import com.ivk23.lms.dao.domain.Logs;
import com.ivk23.lms.dao.repository.LogsRepository;
import com.ivk23.lms.service.LoggerService;

@Service
@Transactional
public class LoggerServiceImpl implements LoggerService {
	
	@Autowired
	private LogsRepository logsRepo;

	@Override
	public ILogs createLog(ILogs log) {
		Logs entity = new Logs(log.getMethod(), log.getParams(), log.getInvokationDate());
		return logsRepo.save(entity);
	}

	@Override
	public List<ILogs> getAll() {
		return logsRepo.findAll();
	}

}
