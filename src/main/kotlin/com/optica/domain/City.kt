package com.optica.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class City {

    @Id
    @GeneratedValue
    private val id: Long? = null

    private val cityName: String? = null

    private val mainCity: Boolean? = null

    private val latitude: Long? = null

    private val length: Long? = null


}
