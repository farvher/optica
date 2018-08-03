/**
 *
 */
package com.optica.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

import com.optica.domain.Apply
import com.optica.repository.ApplyDao
import com.optica.repository.CurriculumDao
import com.optica.repository.JobOfferDao


@Service
class ApplyServiceImpl : ApplyService {

    @Autowired
    private val applyDao: ApplyDao? = null

    @Autowired
    private val curriculumDao: CurriculumDao? = null

    @Autowired
    private val jobOfferDao: JobOfferDao? = null


    override fun getAppliesByCurriculum(id: Long?, pageable: Pageable): List<Apply> {
        return applyDao!!.findByCurriculumId(id, pageable)
    }


    override fun getAppliesByJobOffer(id: Long?, pageable: Pageable): List<Apply> {
        return applyDao!!.findByJobOfferId(id, pageable)
    }


    override fun applyForJobOffer(apply: Apply) {
        val curriculumId = apply.curriculumId
        val jobOfferId = apply.jobOfferId

    }


    override fun deleteApply(id: Long?) {
        applyDao!!.deleteById(id!!)

    }

}
