package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Red Tornado"
 */
object ThemeRedTornado {

    const val KEY = "Red Tornado"
    
    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xffc62828),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffffcdd2),
        onPrimaryContainer = Color(0xff141112),
        secondary = Color(0xffc2185b),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xfffce4ec),
        onSecondaryContainer = Color(0xff141314),
        tertiary = Color(0xffad1457),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xfff8bbd0),
        onTertiaryContainer = Color(0xff141011),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdf9f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdf9f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe3e3),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151111),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffc1c1),
        surfaceTint = Color(0xffc62828),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffef9a9a),
        onPrimary = Color(0xff141010),
        primaryContainer = Color(0xffb71c1c),
        onPrimaryContainer = Color(0xfffce4e4),
        secondary = Color(0xfffce4ec),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xffc2185b),
        onSecondaryContainer = Color(0xfffee3ee),
        tertiary = Color(0xfff8bbd0),
        onTertiary = Color(0xff141214),
        tertiaryContainer = Color(0xffad1457),
        onTertiaryContainer = Color(0xfffae2ed),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1c1717),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1c1717),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff453c3c),
        onSurfaceVariant = Color(0xffe1e0e0),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffef9f9),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff755050),
        surfaceTint = Color(0xffef9a9a),
    )

}