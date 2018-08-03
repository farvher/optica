package com.optica.domain

import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Curriculum {

    @Id
    @GeneratedValue
    var id: Long? = null

    var document: Long? = null

    var documentType: String? = null

    var name: String? = null

    var lastName: String? = null

    var birthDate: LocalDate? = null

    var gender: Long? = null

    var phone: String? = null

    var phone2: String? = null

    var skype: String? = null

    var cityId: Long? = null

    var address: String? = null

    var countryId: Long? = null

    var drivingLicense: String? = null

    var disability: Boolean? = null

    var urlProfilePic: String? = null

    var introductionTitle: String? = null

    var introduction: String? = null

    var currentSituation: String? = null

    var workAreaId: Long? = null


}
