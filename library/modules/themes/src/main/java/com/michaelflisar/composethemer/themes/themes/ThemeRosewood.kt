package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Rosewood"
 */
object ThemeRosewood {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Rosewood",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff5c000e),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xfff4cace),
        onPrimaryContainer = Color(0xff141111),
        secondary = Color(0xff74540e),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffffdea3),
        onSecondaryContainer = Color(0xff14120e),
        tertiary = Color(0xffad8845),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffe8c0),
        onTertiaryContainer = Color(0xff141310),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffaf8f8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffaf8f8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe5e0e1),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff131010),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffd18a95),
        surfaceTint = Color(0xff5c000e),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff9c5a69),
        onPrimary = Color(0xfffbf6f7),
        primaryContainer = Color(0xff5f111e),
        onPrimaryContainer = Color(0xffeee2e4),
        secondary = Color(0xffedce9b),
        onSecondary = Color(0xff141410),
        secondaryContainer = Color(0xff805e23),
        onSecondaryContainer = Color(0xfff3eee5),
        tertiary = Color(0xfff5dfb9),
        onTertiary = Color(0xff141412),
        tertiaryContainer = Color(0xff8e6e3c),
        onTertiaryContainer = Color(0xfff6f1e9),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff181415),
        onBackground = Color(0xffececec),
        surface = Color(0xff181415),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff3c3637),
        onSurfaceVariant = Color(0xffe0dfdf),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9f6f7),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff52353b),
        surfaceTint = Color(0xff9c5a69),
    )

}