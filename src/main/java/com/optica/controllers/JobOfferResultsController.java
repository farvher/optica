package com.optica.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.optica.dto.ResultPageDTO;
import com.optica.services.search.FilterJobOfferService;
import com.optica.services.search.SearchJobOfferService;

public class JobOfferResultsController {

	private static final String RESULT_PAGE = "";
	
	
	@Autowired
	private SearchJobOfferService searchJobOfferService;

	@Autowired
	private FilterJobOfferService filterJobOfferService;
	
	
	@GetMapping("/find")
	public String find(String query , HttpServletRequest request, Model model) {
		
		
		return RESULT_PAGE;
	}  
	

	/**
	 * search by filters
	 * */
	public void executeSearch(Model model, HttpServletRequest request) {
		ResultPageDTO resultPage = new ResultPageDTO();
		resultPage.setJobOffers(filterJobOfferService.filterJobOffer(request.getParameterMap()));
		model.addAttribute("resultPage", resultPage);		
	}

	/**
	 * initial search
	 * */
	public void executeSearch(String city, String keyword, Model model, HttpServletRequest request) {
		ResultPageDTO resultPage = new ResultPageDTO();
		resultPage.setJobOffers(searchJobOfferService.findJobOffersByKeywordAndCity(keyword, city));
		model.addAttribute("resultPage", resultPage);		
	}

}
