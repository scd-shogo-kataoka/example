
buildscript {
    dependencies {
        classpath("com.mysql:mysql-connector-j:8.0.33")
        classpath("org.flywaydb:flyway-mysql:9.22.2")
    }
}

plugins {
    id("org.flywaydb.flyway") version "9.22.1"
}

repositories { mavenCentral() }

flyway {
    url = "jdbc:mysql://127.0.0.1:13306/example"
    user = "example"
    password = "example"
}