pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Formula 1 Tracker App"
include(":app")
include(":core")
include(":features")
include(":features:main")
include(":features:standings")
include(":features:race-results")
include(":features:driver-details")
include(":app:mylibrary")
include(":base")
