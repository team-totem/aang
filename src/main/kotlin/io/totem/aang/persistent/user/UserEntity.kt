package io.totem.aang.persistent.user

import io.totem.aang.doamin.user.model.UserStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var email: String,
    @Column(name = "hash_password", nullable = false)
    var password: String,
    @Column(nullable = false)
    val status: UserStatus
) {

    constructor(email: String, password: String, status: UserStatus) :
            this(id = null, email = email, password = password, status = status)
}
