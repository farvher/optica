package com.optica.services;

import java.util.List;

import com.optica.domain.Company;

public interface CompanyService {

	Company findCompany(Long id);

	List<Company> findAllCompanies();

}
