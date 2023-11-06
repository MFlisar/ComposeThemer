package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "San Juan Blue"
 */
object ThemeSanJuanBlue {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "San Juan Blue",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff375778),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffa4c4ed),
        onPrimaryContainer = Color(0xff0e1014),
        secondary = Color(0xfff2c4c7),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xffffe3e5),
        onSecondaryContainer = Color(0xff141313),
        tertiary = Color(0xfff98d94),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xffffc4c6),
        onTertiaryContainer = Color(0xff141011),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9fafb),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9fafb),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e5e7),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121213),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffc3d7eb),
        surfaceTint = Color(0xff375778),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff5e7691),
        onPrimary = Color(0xfff6f8fa),
        primaryContainer = Color(0xff375778),
        onPrimaryContainer = Color(0xffe8edf2),
        secondary = Color(0xfff4cfd1),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xff96434f),
        onSecondaryContainer = Color(0xfff7eaec),
        tertiary = Color(0xffeba1a6),
        onTertiary = Color(0xff141011),
        tertiaryContainer = Color(0xffae424f),
        onTertiaryContainer = Color(0xfffbeaec),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff141617),
        onBackground = Color(0xffececec),
        surface = Color(0xff141617),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff36383b),
        onSurfaceVariant = Color(0xffdfdfe0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff6f8f9),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff36414d),
        surfaceTint = Color(0xff5e7691),
    )

}