package com.optica.domain.app

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class MailSender {

    @Id
    @GeneratedValue
    var id: Long? = null

    var mailContent: String

    var subject: String


}
