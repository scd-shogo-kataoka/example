plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

dependencies {
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("com.mysql:mysql-connector-j:8.0.33")

    val exposedVersion = "0.43.0"
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")


    // test
//    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.testcontainers:mysql:1.19.0")
    testImplementation("org.testcontainers:junit-jupiter:1.19.0")

    val flywayVersion = "9.22.2"
    testImplementation("org.flywaydb:flyway-core:$flywayVersion")
    testImplementation("org.flywaydb:flyway-mysql:$flywayVersion")
}

tasks.test {
    useJUnitPlatform()
    sourceSets.getByName("test").resources.srcDir("../flyway/src/main/resources")
}