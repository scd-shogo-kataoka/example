package jp.example.infra.repositories.account

import jp.example.domain.entities.account.Account
import jp.example.domain.repositories.account.AccountRepository
import jp.example.infra.entities.account.AccountRecord
import jp.example.infra.mappers.account.AccountMapper
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
open class AccountRepositoryImpl : AccountRepository {
    override fun selectById(id: Long): Account? {
        return transaction { AccountRecord.findById(id) }?.toModel()
    }

    fun selectAll(): List<Account> {
        return transaction { AccountRecord.all() }.map { it.toModel() }
    }

    override fun save(entity: Account): Account {
        val created = transaction {
            AccountRecord.new {
                this.email = entity.email
                this.password = entity.password
                this.name = entity.name
                this.createdAt = entity.createdAt.toInstant()
                this.updatedAt = entity.updatedAt.toInstant()
            }
        }
        return created.toModel()
    }

    private fun AccountRecord.toModel(): Account {
        return Account(
            this.id.value,
            this.email,
            this.password ?: "",
            this.name,
            Date.from(this.createdAt ?: Date().toInstant()),
            Date.from(this.updatedAt ?: Date().toInstant())
        )
    }
}

