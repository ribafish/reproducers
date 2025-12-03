// The pluginManagement block gets merged with the settings.gradle.kts this gets applied to
pluginManagement {
    repositories {
        maven {
            url = uri("https://plugins.grdev.net/m2")
        }
        maven {
            url = uri("https://repo.grdev.net:443/artifactory/gradle-plugin-portal-prod-cache/")
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        maven {
            url = uri("https://plugins.grdev.net/m2")
        }
    }
}