package com.demo.async.controller;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.async.service.AsyncService;
import com.demo.async.service.TaskStatusService;

@RestController
public class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncService asyncService;

	@Autowired
	private TaskStatusService statusService;

	/**
	 * Create new task
	 * 
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createTask() throws InterruptedException, ExecutionException {
		log.info("testAsync Start...");

		// create new task
		long taskId = statusService.getTaskId();

		// choice success / failure task
		if (taskId % 2 == 1) {
			asyncService.doTask1(taskId);
		} else {
			asyncService.doTask2(taskId);
		}

		log.info("testAsync Complete...");

		// return task id
		return String.valueOf(taskId);
	}

	/**
	 * Confirm task status with taskId
	 * 
	 * @param taskId
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String getStatus(@RequestParam(name = "id") long taskId) throws InterruptedException, ExecutionException {
		log.info("testAsync Start...");

		// get task status
		String status = statusService.getStatus(taskId);

		log.info("testAsync Complete...");

		// return task status
		return status;
	}
}
