package io.totem.aang.doamin.user.service

import io.totem.aang.doamin.user.dto.JoinDto
import io.totem.aang.doamin.user.dto.toModel
import io.totem.aang.doamin.user.model.UserRepository
import io.totem.aang.doamin.user.model.created
import io.totem.aang.doamin.user.model.verify
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserJoinService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun join(dto: JoinDto) {

        val user = dto.toModel()

        user.verify(repository = userRepository)

        // todo : hash password

        user.created(repository = userRepository)
    }
}
