package com.demo.async.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.async.domain.TaskStatus;
import com.demo.async.repository.TaskStatusRepository;

@Service
public class TaskStatusService {

	@Autowired
	TaskStatusRepository repo;

	public Long getTaskId() {
		TaskStatus status = new TaskStatus();
		status.setStatus("Started");

		repo.save(status);

		return status.getId();
	}

	public String getStatus(long id) {
		Optional<TaskStatus> entity = repo.findById(Long.valueOf(id));

		return entity.get().getStatus();
	}
}
