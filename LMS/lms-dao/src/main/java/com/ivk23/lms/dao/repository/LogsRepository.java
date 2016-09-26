package com.ivk23.lms.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.ivk23.lms.commons.interfaces.ILogs;
import com.ivk23.lms.dao.domain.Logs;

public interface LogsRepository extends Repository<Logs, Long> {
	
	ILogs save(ILogs log);
	
	List<ILogs> findAll();

}
