import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose)
}

kotlin {

    jvm {
        withJava()
    }

    sourceSets {
        val jvmMain by getting {
            dependencies {

                implementation(compose.desktop.currentOs)

                implementation(project(":composethemer:core"))
                implementation(project(":composethemer:modules:picker"))
                implementation(project(":composethemer:modules:themes:metro"))

                implementation(deps.toolbox.core)
                implementation(deps.toolbox.ui)

            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.michaelflisar.composethemer.demo.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Exe)
            packageName = "Compose Themer Demo"
            packageVersion = "1.0.0"
        }
    }
}