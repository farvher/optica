package com.optica.services.login

import com.optica.entity.User

interface UserService {

    fun save(user: User)

    fun findByUsername(username: String?): User

    fun findById(id: Long?): User

    fun findAll(): List<User>
}
