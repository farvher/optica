package com.optica.controllers

import javax.servlet.http.HttpServletRequest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import com.optica.entity.User
import com.optica.services.login.RoleService
import com.optica.services.login.SecurityService
import com.optica.services.login.UserService
import com.optica.util.UserValidator

@Controller
class LoginController {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var securityService: SecurityService

    @Autowired
    private lateinit var userValidator: UserValidator

    @Autowired
    private lateinit var roleService: RoleService

    @RequestMapping(value = MappingConstants.REGISTRATION_PATH, method = arrayOf(RequestMethod.GET))
    fun registration(model: Model, user: User): String {
        return "registration"
    }

    @RequestMapping(value = MappingConstants.REGISTRATION_PATH, method = arrayOf(RequestMethod.POST))
    fun registration(@ModelAttribute("user") userForm: User, bindingResult: BindingResult, model: Model,
                     request: HttpServletRequest): String {
        userValidator.validate(userForm, bindingResult)

        if (bindingResult.hasErrors()) {
            return "redirect:/registration"
        }
        val passConfirm = userForm.password
        userForm.roles = roleService!!.findRoleByName("USER")
        userService!!.save(userForm)
        securityService!!.autologin(userForm.username, passConfirm, request)

        return "redirect:/"
    }

    @GetMapping(MappingConstants.LOGIN_PATH)
    fun login(model: Model): String {

        model.addAttribute("roles", roleService!!.findAll())
        model.addAttribute("users", userService!!.findAll())

        return "login"
    }

}
