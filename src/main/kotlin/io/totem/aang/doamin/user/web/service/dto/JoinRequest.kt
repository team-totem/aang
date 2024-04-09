package io.totem.aang.doamin.user.web.service.dto

import io.totem.aang.doamin.user.dto.JoinDto

data class JoinRequest(
    val email: String,
    val password: String
) {

}

fun JoinRequest.toDto(): JoinDto {
    return JoinDto(
        email = email,
        password = password
    )
}

