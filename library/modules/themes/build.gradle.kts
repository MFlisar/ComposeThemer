import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gradle.maven.publish.plugin)
}

// -------------------
// Informations
// -------------------

// Module
val artifactId = "themes"
val androidNamespace = "com.michaelflisar.composethemer.themes"

// Library
val libraryName = "ComposeThemer"
val libraryDescription = "ComposeThemer - $artifactId module"
val groupID = "io.github.mflisar.composethemer"
val release = 2021
val github = "https://github.com/MFlisar/ComposeThemer"
val license = "Apache License 2.0"
val licenseUrl = "$github/blob/main/LICENSE"

// -------------------
// Setup
// -------------------

kotlin {

    // Java
    jvm()

    // Android
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    // iOS
    macosX64()
    macosArm64()
    iosArm64()
    iosX64()
    iosSimulatorArm64()

    // -------
    // Sources
    // -------

    sourceSets {

        commonMain.dependencies {

            // Kotlin
            implementation(kotlinx.coroutines)

            // AndroidX / Google
            implementation(libs.compose.material3)
            //implementation(libs.compose.activity)

            // Library
            implementation(project(":ComposeThemer:Core"))

        }

        androidMain.dependencies {
            //implementation(libs.androidx.lifecycle.compose)
        }
    }
}

android {

    namespace = androidNamespace

    compileSdk = app.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = app.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

mavenPublishing {

    configure(
        KotlinMultiplatform(
            javadocJar = JavadocJar.Dokka("dokkaHtml"),
            sourcesJar = true
        )
    )

    coordinates(
        groupId = groupID,
        artifactId = artifactId,
        version = System.getenv("TAG")
    )

    pom {
        name.set(libraryName)
        description.set(libraryDescription)
        inceptionYear.set("$release")
        url.set(github)

        licenses {
            license {
                name.set(license)
                url.set(licenseUrl)
            }
        }

        developers {
            developer {
                id.set("mflisar")
                name.set("Michael Flisar")
                email.set("mflisar.development@gmail.com")
            }
        }

        scm {
            url.set(github)
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, true)

    // Enable GPG signing for all publications
    signAllPublications()
}



tasks.register("convert_themes") {

    println("Converting...")

    val link = "https://rydmike.com/flexcolorscheme/themesplayground-latest/"
    val version = "FlexColorScheme v8.0.2"

    val excludedStyles = listOf(
        "brightness",
        "primaryFixed",
        "primaryFixedDim",
        "onPrimaryFixed",
        "onPrimaryFixedVariant",
        "secondaryFixed",
        "secondaryFixedDim",
        "onSecondaryFixed",
        "onSecondaryFixedVariant",
        "tertiaryFixed",
        "tertiaryFixedDim",
        "onTertiaryFixed",
        "onTertiaryFixedVariant",
        "shadow"
    )
    val renamedStyles = mapOf(
        "onInverseSurface" to "inverseOnSurface"
    )

    val themesFolderOrig = File("$projectDir/_themes")
    val themesFolderConverted = File("$projectDir/src/commonMain/kotlin/com/michaelflisar/composethemer/themes/themes")
    val composeThemesFile = File("$projectDir/src/commonMain/kotlin/com/michaelflisar/composethemer/themes/ComposeThemes.kt")

    println("")
    println("---------------------------")
    println("- Begin Converting Themes -")
    println("---------------------------")
    println("")

    val themes = themesFolderOrig.listFiles()
    val themeFileNames = ArrayList<String>()
    themes.forEach {

        val theme = it.nameWithoutExtension
        val themeNoSpaces = theme.replace(" ", "")

        themeFileNames += "Theme$themeNoSpaces"

        //println("Theme: $theme")
        val lines = it.readLines(Charsets.UTF_8)

        val lineBeginLightTheme = lines.indexOfFirst { it.contains("lightColorScheme") } + 1
        val lineEndLightTheme = lines.drop(lineBeginLightTheme).indexOfFirst { it.contains(");") } + lineBeginLightTheme - 1
        val lineBeginDarkTheme = lines.indexOfFirst { it.contains("darkColorScheme") } + 1
        val lineEndDarkTheme = lines.drop(lineBeginDarkTheme).indexOfFirst { it.contains(");") } + lineBeginDarkTheme - 1

        val convertLine = { line: String ->
            val parts = line.split(":").map { it.trim() }
            val name = parts[0]
            val value = parts[1]
            if (!excludedStyles.contains(name)) {
                val mappedName = renamedStyles[name] ?: name
                "        $mappedName = $value"
            } else null
        }

        val lightTheme = lines.subList(lineBeginLightTheme, lineEndLightTheme).mapNotNull { convertLine(it) }
        val darkTheme = lines.subList(lineBeginDarkTheme, lineEndDarkTheme).mapNotNull { convertLine(it) }

        //println("- Light: $lineBeginLightTheme => $lineEndLightTheme")
        //println("- Dark: $lineBeginDarkTheme => $lineEndDarkTheme")

        val fileContent = listOf(
            "package com.michaelflisar.composethemer.themes.themes",
            "",
            "import androidx.compose.material3.darkColorScheme",
            "import androidx.compose.material3.lightColorScheme",
            "import androidx.compose.ui.graphics.Color",
            "import com.michaelflisar.composethemer.ComposeTheme",
            "",
            "/**",
            " * Theme taken from the default themes from $link",
            " *",
            " * $version",
            " *",
            " * FlexColor Theme Name: \"Midnight\"",
            " */",
            "object Theme$themeNoSpaces {",
            "",
            "    const val KEY = \"$theme\"",
            "",
            "    fun get() = ComposeTheme.Theme(",
            "        key = KEY,",
            "        colorSchemeLight = Light,",
            "        colorSchemeDark = Dark",
            "    )",
            "",
            "    private val Light = lightColorScheme(",
            lightTheme,
            "    )",
            "",
            "    private val Dark = darkColorScheme(",
            darkTheme,
            "    )",
            "}"
        ).map {
            if (it is String) {
                listOf(it)
            } else (it as List<String>)
        }.flatten()

        val convertedFileContent = fileContent.joinToString("\n")

        val convertedFile = File(themesFolderConverted, "Theme$themeNoSpaces.kt")
        convertedFile.writeText(convertedFileContent, Charsets.UTF_8)

        //println("-----------")
        //println(convertedFile)
        //println("-----------")

        println("Theme $theme created: $convertedFile")

    }

    val fileContentComposeThemes = listOf(
        "package com.michaelflisar.composethemer.themes",
        "",
        "import com.michaelflisar.composethemer.ComposeTheme",
        "import com.michaelflisar.composethemer.themes.themes.ThemeDefault",
        themeFileNames.map {
            "import com.michaelflisar.composethemer.themes.themes.$it"
        },
        "",
        "object ComposeThemes {",
        "",
        "    val ALL: List<ComposeTheme.Theme>",
        "        get() = listOf(",
        "            // default m3 theme",
        "            ThemeDefault.get(),",
        "            // custom themes",
        themeFileNames.map {
            "            $it.get(),"
        },
        "        )",
        "}"
    ).map {
        if (it is String) {
            listOf(it)
        } else (it as List<String>)
    }.flatten()

    val composeThemesFileContent = fileContentComposeThemes.joinToString("\n")
    composeThemesFile.writeText(composeThemesFileContent, Charsets.UTF_8)

    println("")
    println("-------------------------")
    println("- End Converting Themes -")
    println("-------------------------")
    println("")

    println("Converted Themes: ${themes.size}")
}

