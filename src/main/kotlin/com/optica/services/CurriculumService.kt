package com.optica.services

import com.optica.domain.Curriculum

interface CurriculumService {

    fun findById(id: Long?): Curriculum

    fun save(curriculum: Curriculum)

    fun delete(id: Long?)

}
