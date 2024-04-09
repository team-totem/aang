package io.totem.aang.persistent.user

import io.totem.aang.doamin.user.model.User
import io.totem.aang.doamin.user.model.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class UserRepositoryAdapter(
    private val repository: UserJpaRepository
) : UserRepository {

    @Transactional
    override fun save(model: User): User {
        val entity: UserEntity = UserEntity.from(model)
        repository.save(entity)
        return model
    }

    @Transactional
    override fun existsByEmail(email: String): Boolean {
        return repository.findByEmail(email)?.let { true } ?: false
    }

}
