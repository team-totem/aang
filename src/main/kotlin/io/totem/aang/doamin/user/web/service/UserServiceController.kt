package io.totem.aang.doamin.user.web.service

import io.totem.aang.doamin.user.service.UserService
import io.totem.aang.doamin.user.web.service.dto.JoinRequest
import io.totem.aang.doamin.user.web.service.dto.toDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/service/v1/user")
class UserServiceController(
    private val userService: UserService
) {

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    fun join(reqeust: JoinRequest) {
        userService.join(reqeust.toDto())
    }
}

