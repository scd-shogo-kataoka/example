package jp.example.domain.entities.account

import java.util.*

data class Account(
    val id: Long,
    val email: String,
    val password: String,
    val name: String,

    val createdAt: Date,
    val updatedAt: Date,
) {
    companion object {
        fun create(params: AccountCreateParams): Account {
            return Account(
                0,
                params.email,
                params.password,
                params.name,
                Date(),
                Date()
            )
        }
    }
}

data class AccountCreateParams(
    val email: String,
    val password: String,
    val name: String,
)

