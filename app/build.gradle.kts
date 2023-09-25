plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":infra"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.bootRun {
    mainClass = "jp.example.ExampleMainKt"
}