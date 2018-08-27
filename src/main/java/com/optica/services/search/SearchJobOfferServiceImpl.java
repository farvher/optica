package com.optica.services.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.domain.JobOffer;
import com.optica.repository.JobOfferDaoElastic;

 @Service
public class SearchJobOfferServiceImpl implements SearchJobOfferService{

	@Autowired
	private JobOfferDaoElastic jobOfferDaoElastic;
	
	@Override
	public List<JobOffer> findJobOffersByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOffer> findJobOffersByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobOffer> findJobOffersByKeywordAndCity(String keyword, String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
