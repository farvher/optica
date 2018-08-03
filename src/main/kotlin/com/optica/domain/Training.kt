package com.optica.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


/**
 * Formacion academica de la persona
 */
@Entity
class Training {

    @Id
    @GeneratedValue
    private val id: Long? = null

}
