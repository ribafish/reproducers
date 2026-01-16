import org.gradle.api.Project

fun Project.configureMetalava() {
    afterEvaluate {
        tasks.findByName("metalavaCheckCompatibility")?.let { task ->
            task.doLast {
                val filename = this::class.java.declaredFields
                    .find { it.name == "filename" }
                    ?.apply { isAccessible = true }
                    ?.get(this)
                println("$path -> filename: $filename")
            }
        }

    }
}
