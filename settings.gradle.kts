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
    }
}

// --------------
// Library
// --------------

// Android + JVM + iOS + js + wasm
include(":composethemer:core")
project(":composethemer:core").projectDir = file("library/core")

// --------------
// Modules
// --------------

// Android + JVM + iOS + js + wasm
include(":composethemer:modules:picker")
project(":composethemer:modules:picker").projectDir = file("library/modules/picker")
include(":composethemer:modules:defaultpicker")
project(":composethemer:modules:defaultpicker").projectDir = file("library/modules/defaultpicker")
include(":composethemer:modules:themes:metro")
project(":composethemer:modules:themes:metro").projectDir = file("library/modules/themes/metro")
include(":composethemer:modules:themes:flatui")
project(":composethemer:modules:themes:flatui").projectDir = file("library/modules/themes/flatui")
include(":composethemer:modules:themes:material500")
project(":composethemer:modules:themes:material500").projectDir = file("library/modules/themes/material500")

// --------------
// App
// --------------

include(":demo:shared")
include(":demo:app:android")
include(":demo:app:windows")
