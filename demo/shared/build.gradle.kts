import com.michaelflisar.kmpdevtools.Targets
import com.michaelflisar.kmpdevtools.BuildFileUtil
import com.michaelflisar.kmpdevtools.core.Target
import com.michaelflisar.kmpdevtools.configs.*
import com.michaelflisar.kmpdevtools.setupDependencies
import com.michaelflisar.kmpdevtools.setupBuildKonfig

plugins {
    // kmp + app/library
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    // org.jetbrains.kotlin
    alias(libs.plugins.jetbrains.kotlin.compose)
    // org.jetbrains.compose
    alias(libs.plugins.jetbrains.compose)
    // docs, publishing, validation
    // --
    // build tools
    alias(mflisar.plugins.kmpdevtools.buildplugin)
    alias(libs.plugins.buildkonfig)
    // others
    // ...
}

// ------------------------
// Setup
// ------------------------

val module = LibraryModuleConfig.read(project)

// targets
val buildTargets = Targets(
    // mobile
    Target.ANDROID,
    Target.IOS,
    // desktop
    Target.JVM,
    Target.MACOS,
    // web
    Target.WASM
)

val androidConfig = AndroidLibraryConfig.create(
    libraryModuleConfig = module,
    compileSdk = app.versions.compileSdk,
    minSdk = app.versions.minSdk,
    enableAndroidResources = true
)

// ------------------------
// Kotlin
// ------------------------

buildkonfig {
    setupBuildKonfig(project = project, config = module.config)
}

kotlin {

    //-------------
    // Targets
    //-------------

    buildTargets.setupTargetsLibrary(module)
    android {
        buildTargets.setupTargetsAndroidLibrary(module, androidConfig, this)
    }

    // -------
    // Sources
    // -------

    sourceSets {


        commonMain.dependencies {

            // Kotlin
            api(libs.jetbrains.kotlinx.coroutines.core)

            // Compose
            api(libs.jetbrains.compose.ui)
            api(libs.jetbrains.compose.material3)
            api(libs.jetbrains.compose.material.icons.core)
            api(libs.jetbrains.compose.material.icons.extended)

            // library
            api(project(":composethemer:core"))
            api(project(":composethemer:modules:picker"))
            api(project(":composethemer:modules:defaultpicker"))
            api(project(":composethemer:modules:themes:metro"))
            api(project(":composethemer:modules:themes:flatui"))
            api(project(":composethemer:modules:themes:material500"))

        }
    }
}