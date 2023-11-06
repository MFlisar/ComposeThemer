package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Vesuvius Burned"
 */
object ThemeVesuviusBurned {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Vesuvius Burned",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xffa6400f),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffd1aa99),
        onPrimaryContainer = Color(0xff110e0d),
        secondary = Color(0xff185358),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffa3c4c7),
        onSecondaryContainer = Color(0xff0e1011),
        tertiary = Color(0xff144447),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xff7fc0c4),
        onTertiaryContainer = Color(0xff0b1010),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffcf9f8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffcf9f8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffeae4e1),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151210),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffc7a8),
        surfaceTint = Color(0xffa6400f),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffd17d53),
        onPrimary = Color(0xfffff8f5),
        primaryContainer = Color(0xff874e32),
        onPrimaryContainer = Color(0xfff4ece7),
        secondary = Color(0xff5b8a8e),
        onSecondary = Color(0xfff6f9fa),
        secondaryContainer = Color(0xff0d494d),
        onSecondaryContainer = Color(0xffe1ebeb),
        tertiary = Color(0xff3a7175),
        onTertiary = Color(0xfff3f7f8),
        tertiaryContainer = Color(0xff023639),
        onTertiaryContainer = Color(0xffe0e8e8),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1a1614),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1a1614),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff423935),
        onSurfaceVariant = Color(0xffe1dfdf),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffcf8f6),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff684432),
        surfaceTint = Color(0xffd17d53),
    )

}