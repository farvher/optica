package com.optica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.optica.domain.JobOffer;
import com.optica.services.JobDetailService;
import com.optica.services.seo.SeoComponents;

@Controller
public class JobOffersDetailController {

	@Autowired
	private JobDetailService jobDetailService;

	@Autowired
	private SeoComponents seoComponents;

	@GetMapping(value = MappingConstants.JOB_DETAIL_PATH)
	public String detail(Model model, Long id, String title) {
		JobOffer jobOffer = jobDetailService.findById(id);
		model.addAttribute("jobOffer", jobOffer);
		seoComponents.generateSeoComponent(model, jobOffer);
		return "detail";
	}

}
