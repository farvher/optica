package com.optica.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apply {

	@Id
	@GeneratedValue
	private Long id;

	private Long curriculumId;

	private Long jobOfferId;

	private LocalDate applyDate;

	private Boolean active;
}
