package com.optica.services.login

import javax.servlet.http.HttpServletRequest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.stereotype.Service

import com.optica.entity.User

@Service
open class SecurityServiceImpl : SecurityService {


    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val userDetailsService: UserDetailsService? = null

    @Autowired
    private val userService: UserService? = null

    override val currentUser: User
        get() {
            if (SecurityContextHolder.getContext().authentication != null) {
                val principal = SecurityContextHolder.getContext().authentication.principal
                return principal as User
            } else {
                throw IllegalStateException("User not found")
            }
        }


    override fun findLoggedInUsername(): String {
        val userDetails = SecurityContextHolder.getContext().authentication.details
        return if (userDetails is UserDetails) {
            userDetails.username
        } else "Annonymous"
    }

    override fun autologin(username: String?, password: String?, request: HttpServletRequest) {
        val userDetails = userDetailsService!!.loadUserByUsername(username)
        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                userDetails, password, userDetails.authorities)


        val authentication = authenticationManager!!.authenticate(usernamePasswordAuthenticationToken)

        if (usernamePasswordAuthenticationToken.isAuthenticated) {

            val loggedUser = userService!!.findByUsername(username)
            (authentication.principal as User).id = loggedUser.id
            (authentication.principal as User).email = loggedUser.email
            (authentication.principal as User).curriculum = loggedUser.curriculum
            SecurityContextHolder.getContext().authentication = authentication
            logger.debug(String.format("Auto login %s successfully!", username))
        }
    }

    companion object {


        private val logger = LoggerFactory.getLogger(SecurityServiceImpl::class.java!!)
    }

}
