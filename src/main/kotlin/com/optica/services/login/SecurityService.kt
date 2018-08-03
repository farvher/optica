package com.optica.services.login

import javax.servlet.http.HttpServletRequest

import org.springframework.security.core.userdetails.UserDetails

import com.optica.entity.User

interface SecurityService {

    val currentUser: User

    fun findLoggedInUsername(): String

    fun autologin(username: String?, password: String?, request: HttpServletRequest)

}
