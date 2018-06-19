package com.optica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author farsan
 */
@Controller
public class HomeController {

	private static final String VIEW_HOME = "index";

	@GetMapping(MappingConstants.INDEX_PATH)
	public String index() {
		return VIEW_HOME;
	}
	
	@GetMapping(MappingConstants.ABOUT_PATH)
	public String about() {
		return VIEW_HOME;
	}

	@GetMapping(MappingConstants.CONTACT_PATH)
	public String contact() {
		return VIEW_HOME;
	}

	@GetMapping("/team")
	public String team() {
		return "team";
	}

}
