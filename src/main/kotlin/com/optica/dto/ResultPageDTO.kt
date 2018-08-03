package com.optica.dto

import java.io.Serializable

import com.optica.domain.JobOffer

class ResultPageDTO : Serializable {


    var jobOffers: List<JobOffer>? = null

    var total: Int? = null

    var filters: Map<String, Array<String>>? = null

    companion object {

        /**
         *
         */
        private const val serialVersionUID = 1L
    }


}
