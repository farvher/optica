package com.optica.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Long id;
	
	private String cityName;
	
	private Boolean mainCity;
	
	private Long latitude;
	
	private Long length;
	
	
	

}
