package com.optica.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Curriculum {

	@Id
	@GeneratedValue
	private Long id;

	private Long document;

	private String documentType;

	private String name;

	private String lastName;

	private LocalDate birthDate;

	private Long gender;

	private String phone;

	private String phone2;

	private String skype;

	private Long cityId;

	private String address;

	private Long countryId;

	private String drivingLicense;

	private Boolean disability;

	private String URLProfilePic;

	private String introductionTitle;

	private String introduction;

	private String currentSituation;

	private Long workAreaId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public Boolean getDisability() {
		return disability;
	}

	public void setDisability(Boolean disability) {
		this.disability = disability;
	}

	public String getURLProfilePic() {
		return URLProfilePic;
	}

	public void setURLProfilePic(String uRLProfilePic) {
		URLProfilePic = uRLProfilePic;
	}

	public String getIntroductionTitle() {
		return introductionTitle;
	}

	public void setIntroductionTitle(String introductionTitle) {
		this.introductionTitle = introductionTitle;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getCurrentSituation() {
		return currentSituation;
	}

	public void setCurrentSituation(String currentSituation) {
		this.currentSituation = currentSituation;
	}

	public Long getWorkAreaId() {
		return workAreaId;
	}

	public void setWorkAreaId(Long workAreaId) {
		this.workAreaId = workAreaId;
	}



}
