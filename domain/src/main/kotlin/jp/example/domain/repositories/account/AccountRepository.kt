package jp.example.domain.repositories.account

import jp.example.domain.entities.account.Account
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository {
    fun selectById(id: Long): Account?
    fun save(entity: Account): Account
}
