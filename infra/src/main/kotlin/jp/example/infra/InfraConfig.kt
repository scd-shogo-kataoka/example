package jp.example.infra

import org.jetbrains.exposed.sql.Database
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@EnableAutoConfiguration
open class InfraConfig {

    @Bean
    open fun connection(dataSource: DataSource): Database {
        return Database.connect(dataSource)
    }
}