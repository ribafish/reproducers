pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}

plugins {
    id("com.gradle.develocity") version "4.4.1-prerelease"
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
