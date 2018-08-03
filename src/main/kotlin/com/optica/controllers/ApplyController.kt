package com.optica.controllers

import java.time.LocalDate
import java.util.Optional

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

import com.optica.domain.Apply
import com.optica.domain.Curriculum
import com.optica.entity.User
import com.optica.services.ApplyService
import com.optica.services.login.SecurityService

@Controller
class ApplyController {

    @Autowired
    lateinit  var applyService: ApplyService

    @Autowired
    lateinit  var securityService: SecurityService

    @PostMapping("/apply/{jobOfferId}")
    @ResponseBody
    fun applyForJobOffer(model: Model, jobOfferId: Long?): String {

        val apply = Apply()
        val user = securityService!!.currentUser

        if (user.curriculum != null) {
            apply.active = true
            apply.applyDate = LocalDate.now()
            apply.curriculumId = user.curriculum!!.id
            apply.jobOfferId = jobOfferId
            applyService!!.applyForJobOffer(apply)
        }

        return "success"
    }

}
