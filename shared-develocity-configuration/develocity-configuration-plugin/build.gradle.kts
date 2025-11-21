plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

dependencies {
    implementation("com.gradle:develocity-gradle-plugin:4.2.2")
    implementation("com.gradle:common-custom-user-data-gradle-plugin:2.4.0")
}

gradlePlugin {
    plugins {
        register("develocityConfiguration") {
            id = "com.example.develocity-configuration"
            implementationClass = "com.example.DevelocityConfigurationPlugin"
        }
    }
}
