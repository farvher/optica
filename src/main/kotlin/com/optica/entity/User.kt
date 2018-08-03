package com.optica.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table
import javax.persistence.Transient

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import com.optica.domain.Curriculum

@Entity
@Table(name = "users")
class User : UserDetails {

    @Id
    @GeneratedValue
    var id: Long? = null

    private var username: String? = null

    var email: String? = null

    private var password: String? = null

    @ManyToMany
    @JoinTable(name = "user_role")
    var roles: List<Role>? = null

    @Transient
    var curriculum: Curriculum? = null

    @Transient
    private var authorities: Collection<GrantedAuthority>? = null

    constructor() {}

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }

    constructor(username: String?, password: String?, grantedAuthorities: Set<GrantedAuthority>) {
        this.username = username
        this.password = password
        this.authorities = grantedAuthorities
    }

    override fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    override fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    override fun getAuthorities(): Collection<GrantedAuthority>? {
        return authorities
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    companion object {

        private val serialVersionUID = 1L
    }

}
