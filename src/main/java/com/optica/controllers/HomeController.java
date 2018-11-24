package com.optica.controllers;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.optica.constants.ENotifications;
import com.optica.domain.JobOffer;
import com.optica.repository.JobOfferDao;
import com.optica.services.search.SearchJobOfferService;
import com.optica.services.search.SearchService;

/**
 * Controlador de landing page y paginas estaticas de la aplicacion <br>
 * Home <br>
 * Contacts <br>
 * About<br>
 * Team<br>
 * 
 * 
 * @author fsanmiguel
 */
// TODO Migrar paginas a una singlepage
@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SearchService searchService;

	@Autowired
	private JobOfferDao offerDao;

	@Autowired
	private SearchJobOfferService searchJobService;
	
	
	@GetMapping({Routes.INDEX_PATH})
	public String home () {
		return "octopus/index";
	}
	
	@GetMapping("/{page:[a-zA-Z1-9-]+.html}")
	public String getStaticPage(@PathVariable String page) {
		
		return "octopus/"+page;
	}

	//@GetMapping(Routes.INDEX_PATH)
	public String index(HttpServletRequest request, Model model) {
    	model.addAttribute("jobs", searchService.searchByQueryString("DESARROLLO"));
		return "index";
	}

	@GetMapping(Routes.ABOUT_PATH)
	public String about(Model model) {
		return "about";
	}

	@GetMapping("/redirect")
	public String redirect(String success, String info, String warning, String danger ,RedirectAttributes redirect) {
		
		if(success!=null) 	
			redirect.addFlashAttribute(ENotifications.SUCCESS.getNotification(), success);
		
		if(info!=null) 	
			redirect.addFlashAttribute(ENotifications.INFO.getNotification(), info);
		
		if(warning!=null) 	
			redirect.addFlashAttribute(ENotifications.WARNING.getNotification(), warning);
		
		if(danger!=null) 	
			redirect.addFlashAttribute(ENotifications.DANGER.getNotification(), danger);
		
		return "redirect:/";
	}

	@GetMapping(Routes.CONTACT_PATH)
	public String contact() {
		return "contact";
	}

	@GetMapping(Routes.TEAM_PATH)
	public String team() {
		return "team";
	}

	@PostMapping(Routes.CONTACT_PATH)
	@ResponseBody
	public String contant(Model model) {

		return "success";
	}

}
