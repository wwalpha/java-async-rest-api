package com.demo.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.demo.async.domain.TaskStatus;
import com.demo.async.repository.TaskStatusRepository;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Autowired
	TaskStatusRepository repo;

	@Async("asyncExecutor")
	public void doTask1(long id) throws InterruptedException {
		log.info("Task1 Start...");

		// simulate task execution for 15s
		Thread.sleep(15000L);

		TaskStatus entity = repo.findById(Long.valueOf(id)).get();
		entity.setStatus("Finish");

		repo.save(entity);

		log.info("Task1 Completed...");
	}

	@Async("asyncExecutor")
	public void doTask2(long id) throws InterruptedException {
		log.info("Task2 Start...");

		// simulate task execution for 10s
		Thread.sleep(10000L);

		TaskStatus entity = repo.findById(Long.valueOf(id)).get();
		entity.setStatus("Error");

		repo.save(entity);

		log.info("Task2 Completed...");
	}
}
