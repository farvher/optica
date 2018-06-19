package com.optica.services.seo;

import java.util.Map;

import org.springframework.ui.Model;

import com.optica.domain.JobOffer;

public interface SeoComponents {

	/**
	 * SEO in search
	 * */
	void generateSeoComponents(Model model, Map<String, String> filters);

	/**
	 * SEO in detail
	 * */
	void generateSeoComponent(Model model, JobOffer jobOffer);

}
