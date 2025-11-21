apply<InternalRepositoryPlugin>()

class InternalRepositoryPlugin : Plugin<Gradle> {
    override fun apply(gradle: Gradle) {
        val canBeMirrored: Spec<MavenArtifactRepository> =
                Spec { r ->
//                    r.getName().equals(ArtifactRepositoryContainer.DEFAULT_MAVEN_CENTRAL_REPO_NAME) ||
                        r.getName().equals("Gradle Central Plugin Repository")
                }

        val useMirror: Action<MavenArtifactRepository> = Action {
            val mirrorUrl: String = "https://company/com/proxy-repository"
            setUrl(mirrorUrl)
        }
        val configureMirror: Action<RepositoryHandler> = Action {
            withType(MavenArtifactRepository::class.java)
                    .matching(canBeMirrored)
                    .configureEach(useMirror)
        }
        gradle.beforeSettings(Action {
            configureMirror.execute(getBuildscript().getRepositories())
            configureMirror.execute(getPluginManagement().getRepositories())
        })
        // Remove the settingsEvaluated part if you are using Gradle <6.8
        gradle.settingsEvaluated(Action {
            configureMirror.execute(getDependencyResolutionManagement().getRepositories())
        })
        gradle.beforeProject(Action {
            configureMirror.execute(getBuildscript().getRepositories())
        })
        gradle.afterProject(Action {
            configureMirror.execute(getRepositories())
        })
    }
}