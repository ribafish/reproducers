plugins {
    kotlin("jvm") version "1.9.25"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.mockito:mockito-core:3.10.0")

    testImplementation(kotlin("test"))

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

//    testImplementation("org.mockito:mockito-junit-jupiter:3.10.0")
//    testImplementation("com.nhaarman:mockito-kotlin:1.6.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.15.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0") // Migrated from com.nhaarman:mockito-kotlin

    testImplementation(enforcedPlatform("org.junit:junit-bom:[5.7.1]"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.junit.platform:junit-platform-engine")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

tasks.test {
    useJUnitPlatform()
}