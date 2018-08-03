package com.optica.repository.login

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import com.optica.entity.Role


@Repository
interface RoleRepository : JpaRepository<Role, Long> {

    override fun findAll(): List<Role>

    fun findByName(name: String): List<Role>


}
