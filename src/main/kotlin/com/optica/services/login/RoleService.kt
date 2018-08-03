package com.optica.services.login

import com.optica.entity.Role

interface RoleService {

    fun save(role: Role)

    fun findRoleByName(role: String): List<Role>

    fun findAll(): List<Role>

}
