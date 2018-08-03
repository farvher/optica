package com.optica.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * @author farsan
 */
@Controller
class HomeController {

    @GetMapping(MappingConstants.INDEX_PATH)
    fun index(): String {
        return "index"
    }

    @GetMapping(MappingConstants.ABOUT_PATH)
    fun about(): String {
        return "about"
    }

    @GetMapping(MappingConstants.CONTACT_PATH)
    fun contact(): String {
        return "contact"
    }

    @GetMapping(MappingConstants.TEAM_PATH)
    fun team(): String {
        return "team"
    }

    @PostMapping(MappingConstants.CONTACT_PATH)
    @ResponseBody
    fun contant(model: Model): String {

        return "success"
    }

}
