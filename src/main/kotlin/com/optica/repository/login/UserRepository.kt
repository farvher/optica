package com.optica.repository.login

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

import com.optica.entity.User


@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findFirstByUsername(username: String?): User

}
