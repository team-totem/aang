package io.totem.aang.doamin.user.dto

import io.totem.aang.doamin.user.model.User

class UserDTO

data class JoinDto(
    val email: String,
    val password: String
)

fun JoinDto.toModel(): User {
    return User(
        this.email,
        this.password
    )
}

