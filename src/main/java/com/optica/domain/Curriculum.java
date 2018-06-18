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
	
		
	
}
