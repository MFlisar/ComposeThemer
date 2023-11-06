package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Mallard And Valencia"
 */
object ThemeMallardAndValencia {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Mallard And Valencia",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff2d4421),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffa3b58a),
        onPrimaryContainer = Color(0xff0e0f0c),
        secondary = Color(0xff959d33),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffe2e989),
        onSecondaryContainer = Color(0xff13130c),
        tertiary = Color(0xffd34b4b),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffdad6),
        onTertiaryContainer = Color(0xff141212),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9f9f8),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9f9f8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e4e2),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111211),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffaebfa5),
        surfaceTint = Color(0xff2d4421),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff808e79),
        onPrimary = Color(0xfff9faf8),
        primaryContainer = Color(0xff2d4421),
        onPrimaryContainer = Color(0xffe6eae4),
        secondary = Color(0xffc3c87a),
        onSecondary = Color(0xff13130d),
        secondaryContainer = Color(0xff454b00),
        onSecondaryContainer = Color(0xffeaebdf),
        tertiary = Color(0xffe18686),
        onTertiary = Color(0xff140e0e),
        tertiaryContainer = Color(0xff501116),
        onTertiaryContainer = Color(0xffece2e3),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff161716),
        onBackground = Color(0xffececec),
        surface = Color(0xff161716),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff393b39),
        onSurfaceVariant = Color(0xffdfe0df),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff8f9f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff454b42),
        surfaceTint = Color(0xff808e79),
    )

}