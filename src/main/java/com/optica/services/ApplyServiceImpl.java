/**
 * 
 */
package com.optica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.optica.domain.Apply;
import com.optica.repository.ApplyDao;
import com.optica.repository.CurriculumDao;
import com.optica.repository.JobOfferDao;


@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDao applyDao;
	
	@Autowired
	private CurriculumDao curriculumDao;
	
	@Autowired
	private JobOfferDao jobOfferDao;
	
	
	@Override
	public List<Apply> getAppliesByCurriculum(Long id,Pageable pageable) {
		return applyDao.findByCurriculumId(id,pageable);
	}


	@Override
	public List<Apply> getAppliesByJobOffer(Long id,Pageable pageable) {
		return applyDao.findByJobOfferId(id,pageable);
	}


	@Override
	public void applyForJobOffer(Apply apply) {
		Long curriculumId = apply.getCurriculumId();
		Long jobOfferId = apply.getJobOfferId();
		if(!applyDao.existByJobOfferIdAndCurriculumId(jobOfferId,curriculumId)) {
			applyDao.save(apply);
		}
	}


	@Override
	public void deleteApply(Long id) {
		applyDao.deleteById(id);

	}

}
