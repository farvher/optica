package com.optica.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Schedule {

    @Id
    @GeneratedValue
    var id: Long? = null

    var scheduleDescription: String? = null

    var scheduleAbreviate: String? = null


}
