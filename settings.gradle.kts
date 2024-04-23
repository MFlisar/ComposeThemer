dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
    versionCatalogs {
        create("deps") {
            from(files("gradle/dependencies.versions.toml"))
        }
        create("compose") {
            from(files("gradle/compose.versions.toml"))
        }
        create("app") {
            from(files("gradle/app.versions.toml"))
        }
    }
}

// --------------
// App
// --------------

include(":ComposeThemer:Core")
project(":ComposeThemer:Core").projectDir = file("library/core")
include(":ComposeThemer:Modules:Themes")
project(":ComposeThemer:Modules:Themes").projectDir = file("library/modules/themes")
include(":demo")
project(":demo").projectDir = file("demo")
