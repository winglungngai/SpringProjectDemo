package org.spring.demo.dao;

import java.util.List;

import org.spring.demo.model.WorkLog;

public interface WorkLogDAO 
{
	public void insert(WorkLog worklog);
	public WorkLog findByWorkLogId(int wid);
	public List<WorkLog> findAllWorkLogs();
}