package io.totem.aang.doamin.user.model

data class User(
    val email: String,
    val password: String,
    var status: UserStatus = UserStatus.NONE
)

fun User.active() {
    this.status = UserStatus.ACTIVE
}

fun User.passive() {
    this.status = UserStatus.PASSIVE
}

enum class UserStatus {
    ACTIVE,
    PASSIVE,
    NONE
}



