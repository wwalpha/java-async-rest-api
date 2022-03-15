package com.demo.async.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.async.domain.TaskStatus;

@Repository
public interface TaskStatusRepository extends CrudRepository<TaskStatus, Long>{

}
