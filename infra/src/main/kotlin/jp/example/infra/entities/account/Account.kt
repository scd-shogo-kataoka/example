package jp.example.infra.entities.account

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.isNotNull
import org.jetbrains.exposed.sql.javatime.timestamp

object Accounts : LongIdTable("account") {
    val email = varchar("email", 255)
    val password = varchar("password", 64).nullable()
    val name = varchar("name", 64)

    val createdAt = timestamp("created_at").nullable()
    val updatedAt = timestamp("updated_at").nullable()
}

class AccountRecord(id: EntityID<Long>) : LongEntity(id) {
    companion object: LongEntityClass<AccountRecord>(Accounts)

    var email by Accounts.email
    var password by Accounts.password
    var name by Accounts.name
    var createdAt by Accounts.createdAt
    var updatedAt by Accounts.updatedAt
}

