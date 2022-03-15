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

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createTask() throws InterruptedException, ExecutionException {
		log.info("testAsync Start...");

		long taskId = statusService.getTaskId();

		if (taskId % 2 == 1) {
			asyncService.doTask1(taskId);
		} else {
			asyncService.doTask2(taskId);
		}

		log.info("testAsync Complete...");

		return String.valueOf(taskId);
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String getStatus(@RequestParam(name = "id") long taskId) throws InterruptedException, ExecutionException {
		log.info("testAsync Start...");

		String status = statusService.getStatus(taskId);

		log.info("testAsync Complete...");

		return status;
	}
}
