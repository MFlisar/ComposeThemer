import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose)
}

kotlin {

    jvm()

    sourceSets {
        val jvmMain by getting {
            dependencies {

                implementation(compose.desktop.currentOs)

                implementation(libs.compose.material.icons.core)
                implementation(libs.compose.material.icons.extended)

                implementation(project(":composethemer:core"))
                implementation(project(":composethemer:modules:picker"))
                implementation(project(":composethemer:modules:defaultpicker"))
                implementation(project(":composethemer:modules:themes:metro"))
                implementation(project(":composethemer:modules:themes:flatui"))
                implementation(project(":composethemer:modules:themes:material500"))

                implementation(project(":demo:shared"))

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