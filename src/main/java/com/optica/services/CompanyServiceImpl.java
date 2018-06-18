package com.optica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.domain.Company;
import com.optica.repository.CompanyDao;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company findCompany(Long id) {
		return companyDao.findById(id).get();
	}

	@Override
	public List<Company> findAllCompanies() {
		return companyDao.findAll();
	}

}
