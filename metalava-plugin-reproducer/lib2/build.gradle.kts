plugins {
    id("com.android.library")
    id("me.tylerbwong.gradle.metalava")
}

configureMetalava()

android {
    namespace = "com.example.lib2"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    api(project(":lib3"))
}
