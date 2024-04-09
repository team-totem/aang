package io.totem.aang.doamin.user.web.dto

import io.totem.aang.doamin.user.service.dto.JoinDto
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class JoinRequest(
    @field:Email
    val email: String,
    @field:NotEmpty
    val password: String
)

fun JoinRequest.toDto(): JoinDto {
    return JoinDto(
        email = email,
        password = password
    )
}

