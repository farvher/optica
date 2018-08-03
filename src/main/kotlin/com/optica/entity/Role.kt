package com.optica.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "roles")
class Role {

    @Id
    @GeneratedValue
    var id: Long? = null

    var name: String? = null

    @ManyToMany(mappedBy = "roles")
    var users: List<User>? = null

}
