package com.demo.async.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "TASK_STATUS")
public class TaskStatus {

	@Setter
	@Getter
	@Id
	@GeneratedValue
	private Long id;

	@Setter
	@Getter
	@Column(name = "status", nullable = false)
	private String status;
}
