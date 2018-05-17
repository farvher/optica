package com.optica.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String scheduleDescription;

	private String scheduleAbreviate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScheduleDescription() {
		return scheduleDescription;
	}

	public void setScheduleDescription(String scheduleDescription) {
		this.scheduleDescription = scheduleDescription;
	}

	public String getScheduleAbreviate() {
		return scheduleAbreviate;
	}

	public void setScheduleAbreviate(String scheduleAbreviate) {
		this.scheduleAbreviate = scheduleAbreviate;
	}
	


}
