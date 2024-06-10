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

rootProject.name = "android-study"
include(":app")
include(":ch01_layout")
include(":ch02_event")
include(":ch03_resource")
include(":ch04_permission")
include(":ch05_dialog")
include(":ch06_notification")
include(":ch07_appbar")
include(":test")
include(":ch08_activity")
include(":ex")
include(":ch09_recycler_view")
include(":ch10_fragment")
include(":ch11_persistence")
include(":ch12_network")
include(":ch13_login")
include(":ch14_etc")
