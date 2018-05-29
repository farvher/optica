package com.optica.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.optica.dto.ResultPageDTO;
import com.optica.services.search.FilterJobOfferService;
import com.optica.services.search.SearchJobOfferService;

public class JobOfferResultsController {

	@Autowired
	private SearchJobOfferService searchJobOfferService;

	@Autowired
	private FilterJobOfferService filterJobOfferService;
	

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
