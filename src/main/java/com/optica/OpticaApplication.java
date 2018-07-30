package com.optica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class OpticaApplication {

	/**
	 * TODO BACK-END
	 * 1. load in session all user data
	 * 2. People -> crud hv
	 * 3. job-offer search by keyword and city
	 * 4. job-offer new offer crud
	 * 5. people apply job offer

	 * TODO FRONT-END
	 * 1. contact form
	 *
	 * */

	public static void main(String[] args) {
		SpringApplication.run(OpticaApplication.class, args);
	}


}
