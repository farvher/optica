package com.optica.domain.app

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import kotlin.properties.Delegates

class MailSender {

    @Id
    @GeneratedValue
    var id: Long? = null

    var mailContent: String by Delegates.notNull()

    var subject: String by Delegates.notNull()


}
