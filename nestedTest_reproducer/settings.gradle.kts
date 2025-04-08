plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("com.gradle.develocity") version("3.19")
    id("com.gradle.common-custom-user-data-gradle-plugin") version "2.0.2"
}

val isCI = System.getenv("CI") != null

develocity {
    allowUntrustedServer = true // ensure a trusted certificate is configured

    server = "https://ge.solutions-team.gradle.com/" // adjust to your Develocity server

    buildScan {
        uploadInBackground = !isCI
    }
}

buildCache {
    local {
        isEnabled = false
    }
}

rootProject.name = "nestedTest_reproducer"

