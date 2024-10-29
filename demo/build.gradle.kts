plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.compose)
}

android {

    namespace = "com.michaelflisar.composethemer.demo"

    compileSdk = app.versions.compileSdk.get().toInt()

    buildFeatures {
        compose = true
    }

    defaultConfig {
        minSdk = app.versions.minSdk.get().toInt()
        targetSdk = app.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    // ------------------------
    // Kotlin
    // ------------------------

    implementation(libs.kotlin)

    // ------------------------
    // AndroidX
    // ------------------------

    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.material.icons.core)
    implementation(libs.compose.material.icons.extended)

    // ------------------------
    // Libraries
    // ------------------------

    implementation(project(":ComposeThemer:Core"))
    implementation(project(":ComposeThemer:Modules:Themes"))

    // KotPreferences
    implementation(libs.kotpreferences.core)
    implementation(libs.kotpreferences.datastore)
    implementation(libs.kotpreferences.compose)

    // a minimal library that provides some useful composables that I use inside demo activities
    implementation(libs.toolbox.core)
    implementation(libs.toolbox.ui)
    implementation(libs.toolbox.app)
}