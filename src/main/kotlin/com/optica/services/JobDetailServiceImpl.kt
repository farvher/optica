package com.optica.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.optica.domain.JobOffer
import com.optica.repository.JobOfferDao

@Service
class JobDetailServiceImpl : JobDetailService {

    @Autowired
    private val jobOfferDao: JobOfferDao? = null

    override fun findById(id: Long?): JobOffer {
        return jobOfferDao!!.findById(id!!).orElseThrow { IllegalArgumentException("jobOfferDao not found") }
    }

    override fun delete(id: Long?) {
        jobOfferDao!!.deleteById(id!!)
    }

    override fun create(jobOffer: JobOffer) {
        jobOfferDao!!.save(jobOffer)
    }

}
