import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.SonatypeHost
import org.gradle.kotlin.dsl.support.unzipTo
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.incremental.deleteDirectoryContents

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

val description = "provides all the basic dialog classes to use and apply themes"

// Module
val artifactId = "core"
val androidNamespace = "com.michaelflisar.composethemer.core"

// Library
val libraryName = "ComposeThemer"
val libraryDescription = "ComposeThemer - $artifactId module - $description"
val groupID = "io.github.mflisar.composethemer"
val release = 2021
val github = "https://github.com/MFlisar/ComposeThemer"
val license = "Apache License 2.0"
val licenseUrl = "$github/blob/main/LICENSE"

// -------------------
// Variables for Documentation Generator
// -------------------

// # DEP + GROUP are optional arrays!

// OPTIONAL = "false"               // defines if this module is optional or not
// GROUP_ID = "core"                // defines the "grouping" in the documentation this module belongs to
// #DEP = "deps.composables.core|Compose Unstyled (core)|https://github.com/composablehorizons/compose-unstyled/"
// PLATFORM_INFO = ""               // defines a comment that will be shown in the documentation for this modules platform support

// GLOBAL DATA
// BRANCH = "master"        // defines the branch on github (master/main)
// GROUP = "core|Core|core"
// GROUP = "modules|Modules|modules"
// GROUP = "themes|Themes|themes"


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

    // js
    js(IR) {
        browser()
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { browser() }

    // -------
    // Sources
    // -------

    sourceSets {

        val notAndroidMain by creating {
            dependsOn(commonMain.get())
        }

        jvmMain { dependsOn(notAndroidMain) }
        iosMain { dependsOn(notAndroidMain) }
        macosMain { dependsOn(notAndroidMain) }
        jsMain { dependsOn(notAndroidMain) }
        wasmJsMain { dependsOn(notAndroidMain) }

        commonMain.dependencies {

            // Kotlin
            implementation(kotlinx.coroutines.core)

            // AndroidX / Google
            implementation(libs.compose.runtime)
            api(libs.compose.material3)

        }

        androidMain.dependencies {

            implementation(androidx.activity.compose)

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

// -------------------
// Script
// -------------------

// 1) <THEME_NAME>... [Flat UI, Material 500, Metro]
// 1) manually create the main colors with names in "scripts\themes\<THEME_NAME>\colors.txt"
// 2) run "scripts\import_themes_from_web.au3" on windows (only works if firefox is installed and if the homepages have not changed and if the screen resolution is as expected)
// 3) create themes from the downloaded theme files with the following task
data class ThemeData(
    val name: String,
    val variant: String,
    val file: File
) {
    val nameKey = name.lowercase().replace(" ", "_")
    val variantKey = variant.lowercase().replace(" ", "_")
}

tasks.register("create_themes") {

    doLast {

        println("Converting...")

        // this variant is the same as another one... so we don't generate it currently
        val variantsToExclude = listOf("Complementary")

        val themeFolders =
            File("$rootDir/scripts/themes").listFiles()?.toList() ?: emptyList<File>()
        val themeTemplateFile = File("$rootDir/scripts/ThemeTemplate.kt")
        val tempUnzippedFolder = File("$rootDir/temp")

        for (themeFolder in themeFolders) {
            val themeNames = HashSet<String>()
            val themeZipFiles =
                themeFolder.listFiles()?.filter { it.extension == "zip" }?.toList() ?: emptyList()

            val themeName = themeFolder.name
            val themeNameNoSpace = themeName.replace(" ", "")
            val themeModuleName = themeNameNoSpace.lowercase()
            val themesFileName = "${themeNameNoSpace}Themes"

            val themeOutputFolder =
                File("$rootDir\\library\\modules\\themes\\$themeModuleName\\src\\commonMain\\kotlin\\com\\michaelflisar\\composethemer\\themes")
            val themesFile =
                File("$rootDir\\library\\modules\\themes\\$themeModuleName\\src\\commonMain\\kotlin\\com\\michaelflisar\\composethemer\\${themesFileName}.kt")

            println("Converting $themeName | $themeModuleName | $themesFileName...")

            if (!tempUnzippedFolder.exists())
                tempUnzippedFolder.mkdirs()

            val themeDatas = themeZipFiles.map {
                val partsOfName = it.nameWithoutExtension.split("_")
                println("zipFileName = ${it.nameWithoutExtension}")
                val themeName = partsOfName[0]
                val variant = partsOfName[1]
                ThemeData(
                    name = themeName,
                    variant = variant,
                    file = it
                )
            }
                .filter { it.variant !in variantsToExclude }

            // delete old files
            File("$themeOutputFolder").deleteDirectoryContents()



            for (data in themeDatas) {

                val dataNameNoSpace = data.name.replace(" ", "")
                val themeFileNameNoExtension = "Theme${themeNameNoSpace}${dataNameNoSpace}"

                val themeVariants = themeDatas.filter { it.name == data.name }.joinToString(", ") { it.variant }

                tempUnzippedFolder.deleteDirectoryContents()
                unzipTo(tempUnzippedFolder, data.file)

                val colorFile = File(tempUnzippedFolder, "ui/theme/Color.kt")
                val colorFileLines =
                    colorFile.readLines(Charsets.UTF_8).filter { it.startsWith("val ") }

                val targetFileName = File("$themeOutputFolder/${themeFileNameNoExtension}.kt")
                if (!targetFileName.exists()) {
                    themeTemplateFile.copyTo(targetFileName)
                }

                val targetFileLines = targetFileName.readLines(Charsets.UTF_8)
                    .map {
                        it
                            .replace("<FILE_NAME>", themeFileNameNoExtension)
                            .replace("<COLLECTION>", themesFileName)
                            .replace("<GROUP_KEY>", data.nameKey)
                            .replace("<GROUP_NAME>", data.name)
                            .replace("<THEMES>", themeVariants)

                    }.toMutableList()

                // add colors
                var indexColorsEnd = targetFileLines.indexOfFirst { it.trim() == "// colors end" }
                targetFileLines.add(
                    indexColorsEnd,
                    "        object ${data.variant} : ComposeThemeColors {"
                )
                indexColorsEnd++
                targetFileLines.addAll(
                    indexColorsEnd,
                    colorFileLines.map { "            override $it" })
                indexColorsEnd += colorFileLines.size
                targetFileLines.add(indexColorsEnd, "        }")

                // add themes
                val indexThemesEnd = targetFileLines.indexOfFirst { it.trim() == "// themes end" }
                targetFileLines.add(
                    indexThemesEnd,
                    "    object ${data.variant} : BaseTheme(ComposeTheme.Key(\"${data.variantKey}\", \"${data.variant}\"), this, Colors.${data.variant})"
                )

                targetFileName.writeText(targetFileLines.joinToString("\n"), Charsets.UTF_8)

                themeNames += themeFileNameNoExtension
            }

            // themes in MetroFiles.kt unter ALL_GROUPS einfügen
            var themesFileLines = themesFile.readLines(Charsets.UTF_8)
            val indexAllGroupsFrom = themesFileLines.indexOfFirst { it.trim() == "// Themes Begin" }
            val indexAllGroupsEnd = themesFileLines.indexOfFirst { it.trim() == "// Themes End" }
            themesFileLines =
                (themesFileLines.subList(0, indexAllGroupsFrom + 1) + themesFileLines.subList(
                    indexAllGroupsEnd,
                    themesFileLines.size
                ))
                    .toMutableList()
                    .also {
                        it.addAll(indexAllGroupsFrom + 1, themeNames.sorted().map {
                            "        $it,"
                        })
                    }

            themesFile.writeText(themesFileLines.joinToString("\n"), Charsets.UTF_8)
        }

        println("Done")
    }
}