package com.optica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {

	private static final String INDEX = "people";

	@GetMapping("/people")
	public static String index() {
		return INDEX;
	}
	
	

}
