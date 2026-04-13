import com.android.build.gradle.internal.tasks.DeviceProviderInstrumentTestTask
import com.android.build.gradle.internal.tasks.ManagedDeviceInstrumentationTestTask
import com.gradle.develocity.agent.gradle.test.ImportJUnitXmlReports
import com.gradle.develocity.agent.gradle.test.JUnitXmlDialect

plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.junittest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.junittest"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    testOptions {
        managedDevices {
            localDevices {
                create("pixel2Api30") {
                    device = "Pixel 2"
                    apiLevel = 30
                    systemImageSource = "aosp-atd"
                }
            }
        }
    }
}

dependencies {
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test:runner:1.6.2")
}


afterEvaluate {
    tasks.withType<DeviceProviderInstrumentTestTask>().names.forEach {
        ImportJUnitXmlReports.register(
            tasks,
            tasks.named(it),
            JUnitXmlDialect.GENERIC
        )
    }
    tasks.withType<ManagedDeviceInstrumentationTestTask>().names.forEach {
        ImportJUnitXmlReports.register(
            tasks,
            tasks.named(it),
            JUnitXmlDialect.GENERIC
        )
    }
}