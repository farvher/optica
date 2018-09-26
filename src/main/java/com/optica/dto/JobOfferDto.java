package com.optica.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class JobOfferDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="El titulo no puede estar vacio")
	private String title;

	@Length(min=15 , max=200, message = "La descripcion debe estar entre 15 y 200 caracteres")
	@NotEmpty(message="La descripcion no puede estar vacia")
	@NotNull
	private String description;

	@Min(1)
	@Max(50)
	@NotNull
	private Integer vacancies;

	@NotNull
	private Integer experienceYears;

	@Min(18)
	@Max(70)
	private Integer minimunAge;
	
	@NotNull
	private Boolean availabilityToTravel;

	private Boolean active;
	
	@NotNull
	private Boolean availabilityToRelocate;

	private LocalDate publishDate;

	private LocalDate unpublishDate;

	private LocalDate updateDate;

	@NotNull
	private Long cityId;

	
	private Long salary;

	private Long maxSalary;

	private Long minSalary;

	@NotNull
	private Long scheduleId;

	@NotNull
	private Long contactsId;

	@NotNull
	private Long trainingId;

	private Boolean confidential;

	private Long latitude;

	private Long length;

	private Boolean highLight;

}
