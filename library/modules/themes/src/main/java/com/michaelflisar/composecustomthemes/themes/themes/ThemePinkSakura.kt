package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Pink Sakura"
 */
object ThemePinkSakura {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Pink Sakura",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xffce5b78),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffe8b5ce),
        onPrimaryContainer = Color(0xff130f11),
        secondary = Color(0xfffbae9d),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xffffdad1),
        onSecondaryContainer = Color(0xff141211),
        tertiary = Color(0xfff39682),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xffffcfc3),
        onTertiaryContainer = Color(0xff141110),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdfafb),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdfafb),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffece5e7),
        onSurfaceVariant = Color(0xff121112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff161313),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xfffff4f9),
        surfaceTint = Color(0xffce5b78),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffeec4d8),
        onPrimary = Color(0xff141314),
        primaryContainer = Color(0xffce5b78),
        onPrimaryContainer = Color(0xffffeef2),
        secondary = Color(0xfff5d6c6),
        onSecondary = Color(0xff141413),
        secondaryContainer = Color(0xffeba689),
        onSecondaryContainer = Color(0xff281d18),
        tertiary = Color(0xfff7e0d4),
        onTertiary = Color(0xff141414),
        tertiaryContainer = Color(0xffeebda8),
        onTertiaryContainer = Color(0xff28201d),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1c1a1b),
        onBackground = Color(0xffededed),
        surface = Color(0xff1c1a1b),
        onSurface = Color(0xffededed),
        surfaceVariant = Color(0xff454042),
        onSurfaceVariant = Color(0xffe1e1e1),
        outline = Color(0xff7a7a7a),
        outlineVariant = Color(0xff2e2e2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffefbfd),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff75636b),
        surfaceTint = Color(0xffeec4d8),
    )

}