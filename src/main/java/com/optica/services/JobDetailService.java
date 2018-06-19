package com.optica.services;

import com.optica.domain.JobOffer;

public interface JobDetailService {

	JobOffer findById(Long id);

	void delete(Long id);

	void create(JobOffer jobOffer);


}
