import com.michaelflisar.kmpdevtools.BuildFileUtil
import com.michaelflisar.kmpdevtools.Targets
import com.michaelflisar.kmpdevtools.configs.library.AndroidLibraryConfig
import com.michaelflisar.kmpdevtools.core.Platform
import com.michaelflisar.kmpdevtools.core.configs.Config
import com.michaelflisar.kmpdevtools.core.configs.LibraryConfig
import com.michaelflisar.kmpdevtools.setupDependencies
import org.gradle.kotlin.dsl.support.unzipTo

plugins {
    // kmp + app/library
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    // org.jetbrains.kotlin
    alias(libs.plugins.jetbrains.kotlin.compose)
    // org.jetbrains.compose
    alias(libs.plugins.jetbrains.compose)
    // docs, publishing, validation
    alias(libs.plugins.dokka)
    alias(libs.plugins.vanniktech.maven.publish.base)
    alias(libs.plugins.binary.compatibility.validator)
    // build tools
    alias(deps.plugins.kmpdevtools.buildplugin)
    // others
    // ...
}

// ------------------------
// Setup
// ------------------------

val config = Config.read(rootProject)
val libraryConfig = LibraryConfig.read(rootProject)

val buildTargets = Targets(
    // mobile
    android = true,
    iOS = true,
    // desktop
    windows = true,
    macOS = true,
    // web
    wasm = true
)

val androidConfig = AndroidLibraryConfig.create(
    compileSdk = app.versions.compileSdk,
    minSdk = app.versions.minSdk,
    enableAndroidResources = false
)

// -------------------
// Kotlin
// -------------------

kotlin {

    //-------------
    // Targets
    //-------------

    buildTargets.setupTargetsLibrary(project)
    android {
        buildTargets.setupTargetsAndroidLibrary(project, config, libraryConfig, androidConfig, this)
    }

    // -------
    // Sources
    // -------

    sourceSets {

        // ---------------------
        // custom source sets
        // ---------------------

        val notAndroidMain by creating { dependsOn(commonMain.get()) }

        setupDependencies(buildTargets, sourceSets) {

            notAndroidMain supportedBy !Platform.ANDROID

        }

        // ---------------------
        // dependencies
        // ---------------------

        commonMain.dependencies {

            // kotlinx
            implementation(libs.jetbrains.kotlinx.coroutines.core)

            // Compose + AndroidX
            implementation(libs.jetbrains.compose.runtime)
            api(libs.jetbrains.compose.material3)

        }

        androidMain.dependencies {

            implementation(libs.androidx.activity.compose)

        }
    }
}

// -------------------
// Publish
// -------------------

// maven publish configuration
if (BuildFileUtil.checkGradleProperty(project, "publishToMaven") != false)
    BuildFileUtil.setupMavenPublish(project, config, libraryConfig)

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
                val name = partsOfName[0]
                val variant = partsOfName[1]
                ThemeData(
                    name = name,
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
                            "            $it,"
                        })
                    }

            themesFile.writeText(themesFileLines.joinToString("\n"), Charsets.UTF_8)
        }

        println("Done")
    }
}

fun File.deleteDirectoryContents() {
    if (exists() && isDirectory) {
        listFiles()?.forEach { file ->
            if (file.isDirectory) file.deleteDirectoryContents()
            file.delete()
        }
    }
}



