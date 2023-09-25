package jp.example.infra.repositories.account

import jp.example.domain.entities.account.Account
import jp.example.domain.entities.account.AccountCreateParams
import jp.example.infra.InfraTestBase
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Import


@Import(AccountRepositoryImpl::class)
open class Test1(
    @Autowired private val repository: AccountRepositoryImpl,
) : InfraTestBase() {

    @Test
    fun test_select() {
        val accounts = repository.selectAll()
        println("accounts: ${accounts.size}")
    }

    @Test
    open fun test_insert() {
        val account = Account.create(AccountCreateParams("insert_test@test.test", "", "insert_test"))
        val created = repository.save(account)
        assert(created.email == account.email)
        assert(created.password == account.password)
        assert(created.name == account.name)
    }
}