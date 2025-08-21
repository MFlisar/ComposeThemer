dependencyResolutionManagement {

    // repositories for dependencies
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }

    versionCatalogs {
        create("app") {
            from(files("gradle/app.versions.toml"))
        }
        create("androidx") {
            from(files("gradle/androidx.versions.toml"))
        }
        create("kotlinx") {
            from(files("gradle/kotlinx.versions.toml"))
        }
        create("deps") {
            from(files("gradle/deps.versions.toml"))
        }
    }

}

pluginManagement {

    // repositories for build
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

// --------------
// Functions
// --------------

fun includeModule(path: String, name: String) {
    include(name)
    project(name).projectDir = file(path)
}

// --------------
// Library
// --------------

includeModule("library/core", ":composethemer:core")

// --------------
// Modules
// --------------

includeModule("library/modules/picker", ":composethemer:modules:picker")
includeModule("library/modules/defaultpicker", ":composethemer:modules:defaultpicker")
includeModule("library/modules/themes/metro", ":composethemer:modules:themes:metro")
includeModule("library/modules/themes/flatui", ":composethemer:modules:themes:flatui")
includeModule("library/modules/themes/material500", ":composethemer:modules:themes:material500")

// --------------
// Demo
// --------------

include(":demo:shared")
include(":demo:app:android")
include(":demo:app:windows")
