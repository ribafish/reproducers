package com.example

import com.gradle.CommonCustomUserDataGradlePlugin
import com.gradle.develocity.agent.gradle.DevelocityConfiguration
import com.gradle.develocity.agent.gradle.DevelocityPlugin
import com.gradle.develocity.agent.gradle.scan.BuildScanConfiguration
import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings
import org.gradle.caching.configuration.BuildCacheConfiguration
import java.util.Optional

class DevelocityConfigurationPlugin : Plugin<Settings> {

    override fun apply(settings: Settings) {
        settings.pluginManager.apply(DevelocityPlugin::class.java)
        settings.pluginManager.apply(CommonCustomUserDataGradlePlugin::class.java)
        val develocityConfig = settings.extensions.getByType(DevelocityConfiguration::class.java)
        configureDevelocity(develocityConfig)
        configureBuildCache(settings.buildCache, develocityConfig)
    }

    private fun configureDevelocity(develocity: DevelocityConfiguration) {
//        develocity.getServer().set("https://develocity-samples.gradle.com")
        develocity.server.set("https://ge.solutions-team.gradle.com")
        configureBuildScan(develocity.buildScan)
    }

    private fun configureBuildScan(buildScan: BuildScanConfiguration) {
        // CHANGE ME: Apply your Build Scan configuration here
        buildScan.uploadInBackground.set(!isCi())
    }

    private fun configureBuildCache(buildCache: BuildCacheConfiguration, develocity: DevelocityConfiguration) {
        // CHANGE ME: Apply your Build Cache configuration here
        buildCache.remote(develocity.buildCache) {
            setEnabled(true)
            setPush(isCi())
        }

        buildCache.local{
            setEnabled(true)
            setPush(true)
        }
    }

    private fun isCi(): Boolean {
        // CHANGE ME: Apply your environment detection logic here
        return environmentVariable("CI").isPresent
    }

    private fun environmentVariable(name: String): Optional<String> {
        return Optional.ofNullable(System.getenv(name))
    }
}
