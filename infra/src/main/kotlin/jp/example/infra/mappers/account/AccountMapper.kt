package jp.example.infra.mappers.account

import jp.example.infra.entities.account.AccountRecord
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Component

@Component
open class AccountMapper {
    fun selectById(id: Long): AccountRecord? {
        return transaction { AccountRecord.findById(id) }
    }

    fun insert(record: AccountRecord) {
        AccountRecord.new { this.email = record.email }
    }
}