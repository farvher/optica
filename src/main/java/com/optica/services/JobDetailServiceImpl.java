package com.optica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optica.domain.JobOffer;
import com.optica.repository.JobOfferDao;

@Service
public class JobDetailServiceImpl implements JobDetailService {

	@Autowired
	private JobOfferDao jobOfferDao;

	@Override
	public JobOffer findById(Long id) {
		return jobOfferDao.findById(id).orElseThrow(() -> new IllegalArgumentException("jobOfferDao not found"));
	}

	@Override
	public void delete(Long id) {
		jobOfferDao.deleteById(id);
	}

	@Override
	public void create(JobOffer jobOffer) {
		jobOfferDao.save(jobOffer);
	}

}
