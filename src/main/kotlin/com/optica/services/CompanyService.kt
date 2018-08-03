package com.optica.services

import com.optica.domain.Company

interface CompanyService {

    fun findCompany(id: Long?): Company

    fun findAllCompanies(): List<Company>

}
