plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {

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

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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

    // Dependent on Compose BOM
    implementation(compose.material3)
    implementation(compose.activity)
    implementation(compose.material.extendedicons)

    // ------------------------
    // Libraries
    // ------------------------

    // Themer
    implementation(project(":ComposeThemer"))

    // DebugDrawer to add all theming options inside a drawer
    implementation(project(":ComposeDebugDrawer:Core"))
    implementation(project(":ComposeDebugDrawer:Plugins:MaterialPreferences"))

    // Dailogs used to select colors
    implementation(project(":ComposeDialogs:Core"))
    implementation(project(":ComposeDialogs:Modules:Color"))

    // preferences via delegates
    implementation(deps.materialpreferences)
    implementation(deps.materialpreferences.datastore)
}