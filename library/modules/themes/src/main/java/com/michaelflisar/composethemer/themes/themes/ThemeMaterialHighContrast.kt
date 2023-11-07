package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Material High Contrast"
 */
object ThemeMaterialHighContrast {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Material High Contrast",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff0000ba),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffb6b6ff),
        onPrimaryContainer = Color(0xff0f0f14),
        secondary = Color(0xff018786),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffb3f1f0),
        onSecondaryContainer = Color(0xff0f1414),
        tertiary = Color(0xff66fff9),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xffc8f9f7),
        onTertiaryContainer = Color(0xff111414),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff8f8fd),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8f8fd),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe0e0eb),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101015),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xff9999ff),
        surfaceTint = Color(0xff0000ba),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffefb7ff),
        onPrimary = Color(0xff141214),
        primaryContainer = Color(0xff8a61db),
        onPrimaryContainer = Color(0xfff5efff),
        secondary = Color(0xff66fff9),
        onSecondary = Color(0xff0c1414),
        secondaryContainer = Color(0xff043232),
        onSecondaryContainer = Color(0xffe0e7e7),
        tertiary = Color(0xff66fff9),
        onTertiary = Color(0xff0c1414),
        tertiaryContainer = Color(0xff00504d),
        onTertiaryContainer = Color(0xffdfeceb),
        error = Color(0xff9b374d),
        onError = Color(0xff10080a),
        errorContainer = Color(0xff632331),
        onErrorContainer = Color(0xffefe5e7),
        background = Color(0xff1c191d),
        onBackground = Color(0xffedeced),
        surface = Color(0xff1c191d),
        onSurface = Color(0xffedeced),
        surfaceVariant = Color(0xff453f46),
        onSurfaceVariant = Color(0xffe1e0e1),
        outline = Color(0xff7d767d),
        outlineVariant = Color(0xff2e2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffefbff),
        inverseOnSurface = Color(0xff131314),
        inversePrimary = Color(0xff755d77),
        surfaceTint = Color(0xffefb7ff),
    )

}