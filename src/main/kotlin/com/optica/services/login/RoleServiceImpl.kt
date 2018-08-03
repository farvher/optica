package com.optica.services.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import com.optica.entity.Role
import com.optica.repository.login.RoleRepository

@Service
class RoleServiceImpl : RoleService {

    @Autowired
    private val roleRepository: RoleRepository? = null

    override fun save(role: Role) {
        roleRepository!!.save(role)

    }

    override fun findRoleByName(role: String): List<Role> {
        return roleRepository!!.findByName(role)
    }

    override fun findAll(): List<Role> {
        return roleRepository!!.findAll()
    }

}
