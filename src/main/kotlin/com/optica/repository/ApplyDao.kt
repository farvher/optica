package com.optica.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import com.optica.domain.Apply

@Repository
interface ApplyDao : JpaRepository<Apply, Long> {

    fun findByCurriculumId(id: Long?, pageable: Pageable): List<Apply>

    fun findByJobOfferId(id: Long?, pageable: Pageable): List<Apply>

}
