package com.optica.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.optica.domain.Company
import com.optica.repository.CompanyDao

@Service
class CompanyServiceImpl : CompanyService {

    @Autowired
    private val companyDao: CompanyDao? = null

    override fun findCompany(id: Long?): Company {
        return companyDao!!.findById(id!!).get()
    }

    override fun findAllCompanies(): List<Company> {
        return companyDao!!.findAll()
    }

}
