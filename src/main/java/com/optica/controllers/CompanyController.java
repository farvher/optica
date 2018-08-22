package com.optica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.optica.domain.Company;
import com.optica.services.CompanyService;

@RestController()
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping(Routes.COMPANY_HOME)
	public List<Company> getCompanies() {

		return companyService.findAllCompanies();
	}





}
