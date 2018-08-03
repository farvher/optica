package com.optica.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

import com.optica.domain.JobOffer
import com.optica.services.JobDetailService
import com.optica.services.seo.SeoComponents

@Controller
class JobOffersDetailController {

    @Autowired
    private lateinit var jobDetailService: JobDetailService

    @Autowired
    private lateinit var seoComponents: SeoComponents

    @GetMapping(value = MappingConstants.JOB_DETAIL_PATH)
    fun detail(model: Model, id: Long?, title: String): String {
        val jobOffer = jobDetailService!!.findById(id)
        model.addAttribute("jobOffer", jobOffer)
        seoComponents!!.generateSeoComponent(model, jobOffer)
        return "detail"
    }

}
