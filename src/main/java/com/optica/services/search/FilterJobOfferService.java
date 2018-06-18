package com.optica.services.search;

import java.util.List;
import java.util.Map;

import com.optica.domain.JobOffer;

public interface FilterJobOfferService {
	
	List<JobOffer> filterJobOffer(String field, String[] values);

	List<JobOffer> filterJobOffer(Map<String, String[]> filters);
	
}

