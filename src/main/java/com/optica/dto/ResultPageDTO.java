package com.optica.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.optica.domain.JobOffer;

public class ResultPageDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private List<JobOffer> jobOffers;

	private Integer total;

	private Map<String, String[]> filters;

	public List<JobOffer> getJobOffers() {
		return jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Map<String, String[]> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, String[]> filters) {
		this.filters = filters;
	}




}
