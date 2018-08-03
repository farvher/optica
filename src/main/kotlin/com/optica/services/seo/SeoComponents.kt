package com.optica.services.seo

import org.springframework.ui.Model

import com.optica.domain.JobOffer

interface SeoComponents {

    /**
     * SEO in search
     */
    fun generateSeoComponents(model: Model, filters: Map<String, String>)

    /**
     * SEO in detail
     */
    fun generateSeoComponent(model: Model, jobOffer: JobOffer)

}
