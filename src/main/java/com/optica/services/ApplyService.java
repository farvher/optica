package com.optica.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.optica.domain.Apply;

public interface ApplyService {

	List<Apply> getAppliesByCurriculum(Long id,Pageable pageable);
	
	List<Apply> getAppliesByJobOffer(Long id,Pageable pageable);
	
	void applyForJobOffer(Apply apply);
	
	void deleteApply(Long id);
	
}
