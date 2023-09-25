package jp.example.infra

import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.junit.jupiter.api.extension.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers
@ContextConfiguration(classes = [InfraTestConfig::class])
@ExtendWith(DbResetInterceptor::class)
open class InfraTestBase

class DbResetInterceptor : BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {
    private lateinit var transactionEach: Transaction

    override fun beforeAll(context: ExtensionContext?) {
        println("beforeAll")
    }

    override fun afterAll(context: ExtensionContext?) {
        println("afterAll")
    }

    override fun beforeEach(context: ExtensionContext?) {
        println("beforeEach")
        transactionEach = TransactionManager.manager.newTransaction()
    }

    override fun afterEach(context: ExtensionContext?) {
        println("afterEach")
        transactionEach.rollback()
        transactionEach.close()
    }
}