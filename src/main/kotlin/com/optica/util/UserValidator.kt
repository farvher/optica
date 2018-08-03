package com.optica.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

import com.optica.entity.User
import com.optica.services.login.UserService

@Component
class UserValidator : Validator {

    @Autowired
    private val userService: UserService? = null

    override fun supports(arg0: Class<*>): Boolean {
        return User::class.java == arg0
    }

    override fun validate(o: Any?, errors: Errors) {
        val user = o as User?

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty")
        if (user!!.username!!.length < 2 || user.username!!.length > 32) {
            errors.rejectValue("username", "Size")
        }
        if (userService!!.findByUsername(user.username) != null) {
            errors.rejectValue("username", "Duplicate")
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty")
        if (user.password!!.length < 2 || user.password!!.length > 32) {
            errors.rejectValue("password", "Size")
        }

    }

}
