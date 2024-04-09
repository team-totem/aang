package io.totem.aang.doamin.user.service

import io.totem.aang.doamin.user.service.dto.JoinDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(
    private val joinService: UserJoinService
) {

    @Transactional
    fun join(dto: JoinDto) {
        joinService.createdNewUser(dto = dto)
    }
}
