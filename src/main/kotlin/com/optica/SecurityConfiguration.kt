package com.optica

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.BeanIds
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

import com.optica.entity.User
import com.optica.services.login.UserService

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    private val userDetailsService: UserDetailsService? = null

    @Autowired
    private val userService: UserService? = null

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        // http.csrf();

        http.authorizeRequests()
                .antMatchers(*ANY_MATCHER)
                .permitAll()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
//                .successHandler(authenticationSuccessHandler())
                .permitAll()
                .and()
                .logout()
                .permitAll()

    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService>(userDetailsService).passwordEncoder(bCryptPasswordEncoder())
    }

    @Bean(name = arrayOf(BeanIds.AUTHENTICATION_MANAGER))
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

//    private fun authenticationSuccessHandler(): AuthenticationSuccessHandler {
//
//        return { request, response, authentication ->
//            val username = (authentication.getPrincipal() as User).username
//            val loggedUser = userService!!.findByUsername(username)
//            (authentication.getPrincipal() as User).id = loggedUser.id
//            (authentication.getPrincipal() as User).email = loggedUser.email
//            (authentication.getPrincipal() as User).curriculum = loggedUser.curriculum
//            response.sendRedirect("/people")
//        }
//
//    }

    companion object {

        protected val ANY_MATCHER = arrayOf("/resources/**", "/", "/about", "/contact", "/blog", "/team", "/registration", "/detail/**", "/search/**", "/h2-console**")
    }
}
