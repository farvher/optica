package com.optica.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contacts {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private String phone;
	
	private String email;
}
