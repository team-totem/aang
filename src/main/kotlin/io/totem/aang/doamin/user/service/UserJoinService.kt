package io.totem.aang.doamin.user.service

import io.totem.aang.doamin.user.model.User
import io.totem.aang.doamin.user.model.UserRepository
import io.totem.aang.doamin.user.model.active
import io.totem.aang.doamin.user.service.dto.JoinDto
import io.totem.aang.doamin.user.service.dto.toModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserJoinService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun createdNewUser(dto: JoinDto) {

        val user = dto.toModel()

        valid(user)

        // todo : hash password
        user.active()

        userRepository.save(user)
    }

    private fun valid(user: User) {
        require(userRepository.existsByEmail(user.email)) {
            "동일한 이메일이 있습니다"
        }
    }
}
