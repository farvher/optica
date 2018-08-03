package com.optica.services


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.optica.domain.Curriculum
import com.optica.repository.CurriculumDao

@Service
class CurriculumServiceImpl : CurriculumService {

    @Autowired
    private val curriculumDao: CurriculumDao? = null

    override fun findById(id: Long?): Curriculum {
        return curriculumDao!!.findById(id!!).orElse(Curriculum())
    }

    override fun save(curriculum: Curriculum) {
        curriculumDao!!.save(curriculum)

    }

    override fun delete(id: Long?) {
        curriculumDao!!.deleteById(id!!)

    }

}
