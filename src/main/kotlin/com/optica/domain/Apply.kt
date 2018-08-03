package com.optica.domain

import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Apply {

    @Id
    @GeneratedValue
    var id: Long? = null

    var curriculumId: Long? = null

    var jobOfferId: Long? = null

    var applyDate: LocalDate? = null

    var active: Boolean? = null

}
