pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("com.gradle.develocity") version "4.0.2"
}

develocity {
    server = "https://ge.solutions-team.gradle.com"
    buildScan {
        uploadInBackground = false
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "android-junit-xml-import"
include(":app")
