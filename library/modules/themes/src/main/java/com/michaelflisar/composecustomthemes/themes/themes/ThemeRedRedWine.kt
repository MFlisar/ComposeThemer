package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Red Red Wine"
 */
object ThemeRedRedWine {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Red Red Wine",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff9b1b30),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffedbac2),
        onPrimaryContainer = Color(0xff141010),
        secondary = Color(0xffa4121c),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffffdad5),
        onSecondaryContainer = Color(0xff141212),
        tertiary = Color(0xffa70043),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffd9df),
        onTertiaryContainer = Color(0xff141213),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffcf8f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfffcf8f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe9e2e3),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff141111),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffb4c1),
        surfaceTint = Color(0xff9b1b30),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffe4677c),
        onPrimary = Color(0xfffff7f8),
        primaryContainer = Color(0xff9b1b30),
        onPrimaryContainer = Color(0xfff8e4e7),
        secondary = Color(0xffbd545b),
        onSecondary = Color(0xfffdf5f6),
        secondaryContainer = Color(0xff930012),
        onSecondaryContainer = Color(0xfff6dfe2),
        tertiary = Color(0xffc87a98),
        onTertiary = Color(0xfffef8fa),
        tertiaryContainer = Color(0xff910037),
        onTertiaryContainer = Color(0xfff6dfe8),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1b1516),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1b1516),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff443739),
        onSurfaceVariant = Color(0xffe1dfdf),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffdf7f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff703b44),
        surfaceTint = Color(0xffe4677c),
    )

}