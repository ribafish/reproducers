pluginManagement {
    includeBuild("develocity-configuration-plugin")
    repositories {
        // Required for the develocity plugin, otherwise it gets taken from gradlePluginPortal
        maven("https://your/gradle-plugins-remote")
    }
}

plugins {
    id("com.example.develocity-configuration")
}

apply(from = "common-settings.gradle.kts")

rootProject.name = "common-develocity-gradle-configuration-kotlin" // adjust to your project
