package com.optica.services.search

import com.optica.domain.JobOffer

interface SearchJobOfferService {

    fun findJobOffersByKeyword(keyword: String): List<JobOffer>

    fun findJobOffersByCity(city: String): List<JobOffer>

    fun findJobOffersByKeywordAndCity(keyword: String, city: String): List<JobOffer>

}
