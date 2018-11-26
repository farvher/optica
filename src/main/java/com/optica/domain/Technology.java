package com.optica.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Technology {

	
	@Id
    @GeneratedValue
    private Long id;
}
