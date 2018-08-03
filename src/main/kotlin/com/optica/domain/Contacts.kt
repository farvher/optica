package com.optica.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Contacts {

    @Id
    @GeneratedValue
    private val id: Long? = null

    private val name: String? = null

    private val lastName: String? = null

    private val phone: String? = null

    private val email: String? = null
}
