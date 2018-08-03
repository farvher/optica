package com.optica.controllers

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

import com.optica.domain.Curriculum
import com.optica.dto.CurriculumDto
import com.optica.entity.User
import com.optica.services.CurriculumService
import com.optica.services.login.SecurityService

@Controller
class PeopleController {

    @Autowired
    private val curriculumService: CurriculumService? = null

    @Autowired
    private val securityService: SecurityService? = null

    @GetMapping(MappingConstants.PEOPLE_PATH)
    fun index(model: Model): String {
        val user = securityService!!.currentUser
        loadModel(model, user)
        return "people"
    }

    @GetMapping("/people/curriculum/edit")
    fun edit(model: Model, @Valid curriculumDto: CurriculumDto, errors: BindingResult): String {
        val user = securityService!!.currentUser
        loadModel(model, user)
        return "people/edit"
    }

    private fun loadModel(model: Model, user: User) {
        model.addAttribute("user", user)


    }

    companion object {

        @PostMapping("/people/curriculum/edit")
        fun edit(model: Model, @Valid curriculumDto: CurriculumDto): String {
            return "people/edit"
        }
    }

}
