package io.totem.aang.doamin.user.model

data class User(
    val email: String,
    val password: String
)

fun User.verify(repository: UserRepository) {
    require(repository.existsByEmail(this.email)) {
        "동일한 이메일이 있습니다"
    }
}

fun User.created(repository: UserRepository) {
    repository.save(this)
}

