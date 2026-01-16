import org.gradle.api.Project
import org.gradle.api.provider.Property

fun Project.configureMetalava() {
    afterEvaluate {
        tasks.findByName("metalavaCheckCompatibility")?.let { task ->
            task.doLast {
                val filename = try {
                    // Try to get Kotlin property first
                    this::class.members
                        .firstOrNull { it.name == "filename" }
                        ?.call(this)
                        ?: this::class.java.declaredFields
                            .firstOrNull { it.name == "filename" }
                            ?.apply { isAccessible = true }
                            ?.get(this)
                } catch (e: Exception) {
                    null
                } as Property<String>
                println("$path -> filename: ${filename.get()}")

                this.outputs.files.forEach {
                    println("$path -> output file: $it")
                }
            }
        }
    }
}
