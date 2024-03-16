package io.totem.aang.doamin.user.service

import io.totem.aang.doamin.user.dto.JoinDto
import io.totem.aang.doamin.user.dto.toModel
import io.totem.aang.doamin.user.model.UserRepository
import io.totem.aang.doamin.user.model.active
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserJoinService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun join(dto: JoinDto) {

        val user = dto.toModel()

        require(userRepository.existsByEmail(user.email)) {
            "동일한 이메일이 있습니다"
        }

        // todo : hash password

        user.active()

        userRepository.save(user)
    }
}
