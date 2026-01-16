plugins {
    id("com.android.application") version "9.0.0-beta03" apply false
    id("com.android.library") version "9.0.0-beta03" apply false
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false
    id("me.tylerbwong.gradle.metalava") version "0.4.0-alpha03" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
