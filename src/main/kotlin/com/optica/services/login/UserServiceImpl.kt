package com.optica.services.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import com.optica.entity.User
import com.optica.repository.login.RoleRepository
import com.optica.repository.login.UserRepository

@Service
class UserServiceImpl : UserService {

    @Autowired
    private var userRepository: UserRepository? = null
    @Autowired
    private val roleRepository: RoleRepository? = null
    @Autowired
    private val bCryptPasswordEncoder: BCryptPasswordEncoder? = null

    override fun save(user: User) {
        user.setPassword(bCryptPasswordEncoder!!.encode(user.password!!))
        userRepository!!.save(user)

    }

    override fun findByUsername(username: String?): User {
        return userRepository!!.findFirstByUsername(username)
    }

    override fun findAll(): List<User> {
        return userRepository!!.findAll()
    }

    override fun findById(id: Long?): User {
        return userRepository!!.findById(id!!).orElseThrow<IllegalStateException?> { IllegalStateException("User not found by id") }
    }

}
