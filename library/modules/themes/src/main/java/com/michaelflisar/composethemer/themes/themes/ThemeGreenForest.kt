package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Green Forest"
 */
object ThemeGreenForest {

    const val KEY = "Green Forest"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff2e7d32),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffa5d6a7),
        onPrimaryContainer = Color(0xff0e120e),
        secondary = Color(0xff004d40),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff59b1a1),
        onSecondaryContainer = Color(0xff080f0e),
        tertiary = Color(0xff00695c),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xff7dcec4),
        onTertiaryContainer = Color(0xff0b1110),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff9fbf9),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9fbf9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e7e3),
        onSurfaceVariant = Color(0xff111211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111311),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffbceebf),
        surfaceTint = Color(0xff2e7d32),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffa5d6a7),
        onPrimary = Color(0xff101411),
        primaryContainer = Color(0xff1b5e20),
        onPrimaryContainer = Color(0xffe4eee4),
        secondary = Color(0xff4db6ac),
        onSecondary = Color(0xff0a1211),
        secondaryContainer = Color(0xff05514a),
        onSecondaryContainer = Color(0xffe0eceb),
        tertiary = Color(0xff80cbc4),
        onTertiary = Color(0xff0e1313),
        tertiaryContainer = Color(0xff00695c),
        onTertiaryContainer = Color(0xffdff0ee),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff181b18),
        onBackground = Color(0xffecedec),
        surface = Color(0xff181b18),
        onSurface = Color(0xffecedec),
        surfaceVariant = Color(0xff3d423d),
        onSurfaceVariant = Color(0xffe0e1e0),
        outline = Color(0xff767d76),
        outlineVariant = Color(0xff2c2e2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffafcfa),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff556b56),
        surfaceTint = Color(0xffa5d6a7),
    )

}