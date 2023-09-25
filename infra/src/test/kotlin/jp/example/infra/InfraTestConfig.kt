package jp.example.infra

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import org.junit.jupiter.api.extension.*
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@ComponentScan(excludeFilters = [ComponentScan.Filter(Configuration::class)])
@EnableAutoConfiguration
open class InfraTestConfig {

    @Bean
    open fun connection(dataSource: DataSource): Database {
        return Database.connect(dataSource, {}, DatabaseConfig { useNestedTransactions = true })
    }

    @Bean
    open fun migrateStrategy(): FlywayMigrationStrategy {
        return FlywayMigrationStrategy { flyway ->
//            flyway.clean()
            flyway.migrate()
        }
    }
}
