pluginManagement {

    // repositories for build
    repositories {
        mavenCentral()
        google()
    }
}

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
    }

}

// --------------
// Library
// --------------

// Android + JVM + iOS
include(":ComposeThemer:Core")
project(":ComposeThemer:Core").projectDir = file("library/core")

// --------------
// Modules
// --------------

// Android + JVM + iOS
include(":ComposeThemer:Modules:Themes")
project(":ComposeThemer:Modules:Themes").projectDir = file("library/modules/themes")

// --------------
// App
// --------------

include(":demo")
project(":demo").projectDir = file("demo")
