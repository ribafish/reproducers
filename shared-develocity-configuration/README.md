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

## Configuration

The plugin automatically:
- Connects to the configured Develocity server
- Enables local build cache with push enabled
- Enables remote build cache (push only on CI)
- Uploads build scans in the background (unless in CI environment)

Customize behavior by modifying the plugin's configuration methods in `DevelocityConfigurationPlugin.kt`.
