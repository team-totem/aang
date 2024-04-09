package io.totem.aang.doamin.user.web

import io.totem.aang.doamin.user.service.UserService
import io.totem.aang.doamin.user.web.dto.JoinRequest
import io.totem.aang.doamin.user.web.dto.toDto
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping("/join")
    @ResponseStatus(HttpStatus.CREATED)
    fun join(@Validated @RequestBody reqeust: JoinRequest) {
        userService.join(reqeust.toDto())
    }
}

