package com.optica.controllers

import javax.servlet.http.HttpServletRequest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

import com.optica.dto.ResultPageDTO
import com.optica.services.search.FilterJobOfferService
import com.optica.services.search.SearchJobOfferService

class JobOfferResultsController {


    @Autowired
    private lateinit var searchJobOfferService: SearchJobOfferService

    @Autowired
    private lateinit var filterJobOfferService: FilterJobOfferService


    @GetMapping("/find")
    fun find(query: String, request: HttpServletRequest, model: Model): String {


        return RESULT_PAGE
    }


    /**
     * search by filters
     */
    fun executeSearch(model: Model, request: HttpServletRequest) {
        val resultPage = ResultPageDTO()
        resultPage.jobOffers = filterJobOfferService!!.filterJobOffer(request.parameterMap)
        model.addAttribute("resultPage", resultPage)
    }

    /**
     * initial search
     */
    fun executeSearch(city: String, keyword: String, model: Model, request: HttpServletRequest) {
        val resultPage = ResultPageDTO()
        resultPage.jobOffers = searchJobOfferService!!.findJobOffersByKeywordAndCity(keyword, city)
        model.addAttribute("resultPage", resultPage)
    }

    companion object {

        private val RESULT_PAGE = ""
    }

}
