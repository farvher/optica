package com.optica.domain.app

import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Transient


@Entity
class TokenLogin {

    @Id
    @GeneratedValue
    var id: Long? = null

    var token: String

    var expirationDate: LocalDate? = null

    var creationDate: LocalDate

    var enabled: Boolean? = null

    @Transient
    internal var validToken: Boolean? = null

    fun getValidToken(): Boolean? {
        return expirationDate != null && enabled!! && expirationDate!!.isBefore(LocalDate.now())
    }


}
