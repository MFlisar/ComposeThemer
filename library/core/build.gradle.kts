import org.gradle.kotlin.dsl.support.unzipTo
import com.michaelflisar.kmplibrary.BuildFilePlugin
import com.michaelflisar.kmplibrary.setupDependencies
import com.michaelflisar.kmplibrary.Target
import com.michaelflisar.kmplibrary.Targets

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gradle.maven.publish.plugin)
    alias(libs.plugins.binary.compatibility.validator)
    alias(deps.plugins.kmplibrary.buildplugin)
}

// get build file plugin
val buildFilePlugin = project.plugins.getPlugin(BuildFilePlugin::class.java)

// -------------------
// Informations
// -------------------

val androidNamespace = "com.michaelflisar.composethemer.core"

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

// -------------------
// Setup
// -------------------

kotlin {

    //-------------
    // Targets
    //-------------

    buildFilePlugin.setupTargetsLibrary(buildTargets)

    // -------
    // Sources
    // -------

    sourceSets {

        // ---------------------
        // custom source sets
        // ---------------------

        // --
        // e.g.:
        // val nativeMain by creating { dependsOn(commonMain.get()) }
        // nativeMain.dependencyOf(sourceSets, buildTargets, listOf(Target.IOS, Target.MACOS))

        val notAndroidMain by creating { dependsOn(commonMain.get()) }
        notAndroidMain.dependencyOfAll(sourceSets, buildTargets, exclusions = listOf(Target.ANDROID))

        // ---------------------
        // dependencies
        // ---------------------

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

// -------------------
// Configurations
// -------------------

// android configuration
android {
    buildFilePlugin.setupAndroidLibrary(
        androidNamespace = androidNamespace,
        compileSdk = app.versions.compileSdk,
        minSdk = app.versions.minSdk,
        buildConfig = false
    )
}

// maven publish configuration
if (buildFilePlugin.checkGradleProperty("publishToMaven") != false)
    buildFilePlugin.setupMavenPublish()

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



