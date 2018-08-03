package com.optica.services.login

import java.util.Arrays
import java.util.HashSet

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.optica.entity.Role
import com.optica.entity.User
import com.optica.repository.login.UserRepository

@Service
class UserDetailServiceImpl : UserDetailsService {

    @Autowired
    private val userRepository: UserRepository? = null

    @Transactional(readOnly = true)
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository!!.findFirstByUsername(username)
        if (user != null) {

            val grantedAuthorities = HashSet<GrantedAuthority>()
            for (role in user.roles!!) {
                grantedAuthorities.add(SimpleGrantedAuthority(role.name))
            }
            return User(user.username, user.password,
                    grantedAuthorities)
        }
        return org.springframework.security.core.userdetails.User("Anonymous", "Anonymous", Arrays.asList(SimpleGrantedAuthority("ANONYMOUS")))
    }

}
