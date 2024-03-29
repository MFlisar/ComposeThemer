plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
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

    // custom build type for github apk (no signing but minified)
    buildTypes {
        create("github") {
            initWith(getByName("debug"))
            isMinifyEnabled = true
            isShrinkResources = true
            applicationIdSuffix = ".github"
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            matchingFallbacks.add("debug")
        }
    }

    // eventually use local custom signing
    val debugKeyStore = providers.gradleProperty("debugKeyStore").orNull
    if (debugKeyStore != null) {
        signingConfigs {
            getByName("debug") {
                keyAlias = "androiddebugkey"
                keyPassword = "android"
                storeFile = File(debugKeyStore)
                storePassword = "android"
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = compose.versions.compiler.get()
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

    // Compose BOM
    implementation(platform(compose.bom))
    implementation(compose.material3)
    implementation(compose.activity)
    implementation(compose.material.extendedicons)
    implementation(compose.drawablepainter)

    // ------------------------
    // Libraries
    // ------------------------

    implementation(project(":ComposeThemer:Core"))
    implementation(project(":ComposeThemer:Modules:Themes"))

    // KotPreferences
    implementation(deps.kotpreferences.core)
    implementation(deps.kotpreferences.datastore)
    implementation(deps.kotpreferences.compose)

    // a minimal library that provides some useful composables that I use inside demo activities
    implementation(deps.composedemobaseactivity)
}