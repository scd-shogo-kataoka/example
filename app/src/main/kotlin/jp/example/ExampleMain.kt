package jp.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ExampleMain

fun main(args: Array<String>) {
    SpringApplication.run(ExampleMain::class.java, *args)
}