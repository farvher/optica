package com.optica.services.search

import com.optica.domain.JobOffer

interface FilterJobOfferService {

    fun filterJobOffer(field: String, values: Array<String>): List<JobOffer>

    fun filterJobOffer(filters: Map<String, Array<String>>): List<JobOffer>

}

