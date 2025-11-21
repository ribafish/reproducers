// The pluginManagement block gets merged with the settings.gradle.kts this gets applied to
pluginManagement {
    repositories {
        maven("https://your/gradle-plugins-remote")
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        maven("https://your/gradle-plugins-remote")
    }
}