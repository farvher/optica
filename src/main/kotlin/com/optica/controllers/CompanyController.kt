package com.optica.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import com.optica.domain.Company
import com.optica.services.CompanyService

@RestController
class CompanyController {

    @Autowired
    lateinit  var companyService: CompanyService

    val companies: List<Company>
        @ResponseBody
        @GetMapping("/company/all")
        get() = companyService!!.findAllCompanies()

}
