
allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    dependencies {
        "testImplementation"("org.junit.jupiter:junit-jupiter:5.10.0")
    }
}

plugins {
    kotlin("jvm") version "1.9.10" apply false
}

tasks.withType<Test> {
    useJUnitPlatform()
}