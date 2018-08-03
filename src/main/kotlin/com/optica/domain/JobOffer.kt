package com.optica.domain

import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class JobOffer {

    @Id
    @GeneratedValue
    var id: Long? = null

    var title: String? = null

    var description: String? = null

    var vacancies: Int? = null

    var experienceYears: Int? = null

    var minimunAge: Int? = null

    var availabilityToTravel: Boolean? = null

    var active: Boolean? = null

    var availabilityToRelocate: Boolean? = null

    var publishDate: LocalDate? = null

    var unpublishDate: LocalDate? = null

    var updateDate: LocalDate? = null

    var cityId: Long? = null

    var salary: Long? = null

    var maxSalary: Long? = null

    var minSalary: Long? = null

    var scheduleId: Long? = null

    var contactsId: Long? = null

    var trainingId: Long? = null

    var confidential: Boolean? = null

    var latitude: Long? = null

    var length: Long? = null

    var highLight: Boolean? = null


}
