package io.totem.aang.web.service

import io.totem.aang.doamin.user.JoinDto
import io.totem.aang.doamin.user.service.UserJoinService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/service/v1/user")
class UserController(
    private val userJoinService: UserJoinService
) {

    @PostMapping("/join")
    fun join(reqeust: JoinRequest) {
        userJoinService.join(reqeust.toDto())
    }
}

data class JoinRequest(
    val email: String,
    val password: String
)

fun JoinRequest.toDto(): JoinDto {
    return JoinDto(
        email = this.email,
        password = this.password
    )
}
