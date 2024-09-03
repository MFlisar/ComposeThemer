package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Aqua Blue"
 */
object ThemeAquaBlue {

    const val KEY = "Aqua Blue"

    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff35a0cb),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff71d3ed),
        onPrimaryContainer = Color(0xff0a1214),
        secondary = Color(0xff89d1c8),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xff91f4e8),
        onSecondaryContainer = Color(0xff0c1413),
        tertiary = Color(0xff61d4d4),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xff8ff3f2),
        onTertiaryContainer = Color(0xff0c1414),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9fcfd),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9fcfd),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e9ec),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111416),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffceffff),
        surfaceTint = Color(0xff35a0cb),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff5db3d5),
        onPrimary = Color(0xff0b1214),
        primaryContainer = Color(0xff297ea0),
        onPrimaryContainer = Color(0xffe6f3f8),
        secondary = Color(0xffa1e9df),
        onSecondary = Color(0xff101414),
        secondaryContainer = Color(0xff005049),
        onSecondaryContainer = Color(0xffdfeceb),
        tertiary = Color(0xffa0e5e5),
        onTertiary = Color(0xff101414),
        tertiaryContainer = Color(0xff004f50),
        onTertiaryContainer = Color(0xffdfecec),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff14191a),
        onBackground = Color(0xffececed),
        surface = Color(0xff14191a),
        onSurface = Color(0xffececed),
        surfaceVariant = Color(0xff363f42),
        onSurfaceVariant = Color(0xffdfe0e1),
        outline = Color(0xff76767d),
        outlineVariant = Color(0xff2c2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff6fbfc),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff365b6a),
        surfaceTint = Color(0xff5db3d5),
    )

}