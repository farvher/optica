package com.optica.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.optica.domain.Company

@Repository
interface CompanyDao : JpaRepository<Company, Long>
