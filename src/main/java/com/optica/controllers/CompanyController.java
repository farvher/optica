package com.optica.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optica.domain.Company;
import com.optica.services.CompanyService;


/**
 * Controlador para crud de compañias registradas
 * 
 * @author fsanmiguel
 * */
@Controller
public class CompanyController {

	
	private final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService companyService;

	@GetMapping(Routes.COMPANY_HOME)
	public List<Company> getCompanies() {

		return companyService.findAllCompanies();
	}





}
