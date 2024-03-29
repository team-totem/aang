package io.totem.aang.persistent.user

import io.totem.aang.doamin.user.model.User
import io.totem.aang.doamin.user.model.UserRepository
import io.totem.aang.doamin.user.model.UserStatus
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class UserRepositoryAdapter(
    private val repository: UserJpaRepository
) : UserRepository {

    @Transactional
    override fun save(model: User): User {
        require(UserStatus.NONE != model.status)

        val entity: UserEntity = toEntity(model)

        repository.save(entity)

        return model
    }

    @Transactional
    override fun existsByEmail(email: String): Boolean {
        return repository.findByEmail(email)?.let { true } ?: false
    }

    private fun toEntity(model: User): UserEntity {
        return UserEntity(model.email, model.password, model.status)
    }
}
