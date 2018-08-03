package com.optica.services

import org.springframework.data.domain.Pageable

import com.optica.domain.Apply

interface ApplyService {

    fun getAppliesByCurriculum(id: Long?, pageable: Pageable): List<Apply>

    fun getAppliesByJobOffer(id: Long?, pageable: Pageable): List<Apply>

    fun applyForJobOffer(apply: Apply)

    fun deleteApply(id: Long?)

}
