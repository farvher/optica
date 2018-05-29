package com.optica.services.search;

import java.util.List;

import com.optica.domain.JobOffer;

public interface SearchJobOfferService {

	List<JobOffer> findJobOffersByKeyword(String keyword);
	
	List<JobOffer> findJobOffersByCity(String city);
	
	List<JobOffer> findJobOffersByKeywordAndCity(String keyword,String city);
	
}
