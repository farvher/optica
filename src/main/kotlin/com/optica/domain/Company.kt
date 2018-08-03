package com.optica.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Company {

    @Id
    @GeneratedValue
    var id: Long? = null

    var companyName: String? = null

    var nit: String? = null

    var country: String? = null

    var businessSectorId: Long? = null

    var workersNumber: Long? = null

    var urlImage: String? = null

    var description: String? = null

    var address: String? = null

    var phone: String? = null

    var phone2: String? = null

    var webSite: String? = null

    var userIdAdmin: Long? = null

    var cityId: Long? = null

    var neighborhood: String? = null

    var latitude: Long? = null

    var length: Long? = null


}
