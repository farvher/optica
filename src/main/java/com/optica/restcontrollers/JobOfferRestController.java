package com.optica.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.optica.services.search.SearchJobOfferService;

/**
 * Represent a expose service of job offers
 * <p>
 * find by keyword and city<br>
 * find by keyword<br>
 * filter by indexable field sending map or key values<br>
 *
 * @author fsanmiguel
 * @since 1.0
 */
@RestController
public class JobOfferRestController {

	@Autowired
	private SearchJobOfferService searchJobOfferService;

}
