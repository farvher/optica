package com.optica.services

import com.optica.domain.JobOffer

interface JobDetailService {

    fun findById(id: Long?): JobOffer

    fun delete(id: Long?)

    fun create(jobOffer: JobOffer)


}
