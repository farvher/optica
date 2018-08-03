package com.optica.domain.app

import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Transient
import kotlin.properties.Delegates


class TokenLogin {

    @Id
    @GeneratedValue
    var id: Long? = null

    var token: String by Delegates.notNull()

    var expirationDate: LocalDate? = null

    var creationDate: LocalDate? = null

    var enabled: Boolean? = null



}
