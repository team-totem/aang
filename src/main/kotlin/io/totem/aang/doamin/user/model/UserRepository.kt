package io.totem.aang.doamin.user.model

interface UserRepository {
    fun save(model: User): User

    fun existsByEmail(email: String): Boolean
}
