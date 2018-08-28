package com.optica.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.searchbox.annotations.JestId;

@Entity
public class JobOffer {

	@Id
	@GeneratedValue
	@JestId
	private Long id;

	private String title;

	private String description;

	private Integer vacancies;

	private Integer experienceYears;

	private Integer minimunAge;

	private Boolean availabilityToTravel;

	private Boolean active;

	private Boolean availabilityToRelocate;

	private LocalDate publishDate;

	private LocalDate unpublishDate;

	private LocalDate updateDate;

	private Long cityId;

	private Long salary;

	private Long maxSalary;

	private Long minSalary;

	private Long scheduleId;

	private Long contactsId;

	private Long trainingId;

	private Boolean confidential;

	private Long latitude;

	private Long length;

	private Boolean highLight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVacancies() {
		return vacancies;
	}

	public void setVacancies(Integer vacancies) {
		this.vacancies = vacancies;
	}

	public Integer getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(Integer experienceYears) {
		this.experienceYears = experienceYears;
	}

	public Integer getMinimunAge() {
		return minimunAge;
	}

	public void setMinimunAge(Integer minimunAge) {
		this.minimunAge = minimunAge;
	}

	public Boolean getAvailabilityToTravel() {
		return availabilityToTravel;
	}

	public void setAvailabilityToTravel(Boolean availabilityToTravel) {
		this.availabilityToTravel = availabilityToTravel;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getAvailabilityToRelocate() {
		return availabilityToRelocate;
	}

	public void setAvailabilityToRelocate(Boolean availabilityToRelocate) {
		this.availabilityToRelocate = availabilityToRelocate;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public LocalDate getUnpublishDate() {
		return unpublishDate;
	}

	public void setUnpublishDate(LocalDate unpublishDate) {
		this.unpublishDate = unpublishDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getContactsId() {
		return contactsId;
	}

	public void setContactsId(Long contactsId) {
		this.contactsId = contactsId;
	}

	public Long getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}

	public Boolean getConfidential() {
		return confidential;
	}

	public void setConfidential(Boolean confidential) {
		this.confidential = confidential;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Boolean getHighLight() {
		return highLight;
	}

	public void setHighLight(Boolean highLight) {
		this.highLight = highLight;
	}



}
