# Shared Develocity Configuration

A reusable Gradle plugin that centralizes Develocity and build cache configuration across projects.

## Overview

This plugin applies and configures:
- **Develocity**: Build scanning and reporting via Gradle Enterprise
- **Build Cache**: Local and remote caching for faster builds
- **Common Custom User Data**: Standard metadata collection for build scans

This is meant to be used within a single project (monorepo) and used by included builds. For examples on how to set it up for publishing and using across multiple repo, see the [develocity-build-config-samples](https://github.com/gradle/develocity-build-config-samples) repository.

## Usage

Include the plugin in your `settings.gradle.kts`:

```kotlin
pluginManagement {
    includeBuild("develocity-configuration-plugin")
}

plugins {
    id("com.example.develocity-configuration")
}
```

## Advanced Setup

### Using Shared Settings Files with Custom Repositories

When using a composite build with custom repositories and a shared settings file, `pluginManagement` blocks get merged together. This is unavoidable—there's no way to prevent this merging. However, you can control whether the default Gradle Plugin Portal is included.

**Critical requirement**: If you define a `pluginManagement.repositories` block in any settings file (including shared settings files), you must explicitly define at least one repository. Without explicit repositories, Gradle will add the default Gradle Plugin Portal to your configuration, which may not be desired.

1. **Create a shared settings file** (`common-settings.gradle.kts`):
```kotlin
pluginManagement {
    repositories {
        maven("your-custom-repo-url")
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        maven("your-dependency-repo-url")
    }
}
```

2. **Apply the shared settings and define repositories in each settings file** that has `pluginManagement`:
```kotlin
// In settings.gradle.kts and any subproject settings.gradle.kts that uses plugins
apply(from = "common-settings.gradle.kts")

pluginManagement {
    includeBuild("develocity-configuration-plugin")
    repositories {
        maven("your-custom-repo-url")
    }
}

plugins {
    id("com.example.develocity-configuration")
}
```

Since `pluginManagement` blocks are merged when you apply a shared settings file, explicitly defining `repositories` in each `pluginManagement` block ensures you have full control over which repositories are available and prevents the default Gradle Plugin Portal from being implicitly added.

## Configuration

The plugin automatically:
- Connects to the configured Develocity server
- Enables local build cache with push enabled
- Enables remote build cache (push only on CI)
- Uploads build scans in the background (unless in CI environment)

Customize behavior by modifying the plugin's configuration methods in `DevelocityConfigurationPlugin.kt`.
