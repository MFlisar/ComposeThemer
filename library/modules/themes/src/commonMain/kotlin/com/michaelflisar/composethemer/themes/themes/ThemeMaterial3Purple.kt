package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Material 3 Purple"
 */
object ThemeMaterial3Purple {

    const val KEY = "Material 3 Purple"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff6750a4),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffeaddff),
        onPrimaryContainer = Color(0xff131214),
        secondary = Color(0xff625b71),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffe8def8),
        onSecondaryContainer = Color(0xff131214),
        tertiary = Color(0xff7d5260),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffd8e4),
        onTertiaryContainer = Color(0xff141213),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffafafc),
        onBackground = Color(0xff090909),
        surface = Color(0xfffafafc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe6e5e9),
        onSurfaceVariant = Color(0xff121112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff131215),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xfff0e9ff),
        surfaceTint = Color(0xff6750a4),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffd0bcff),
        onPrimary = Color(0xff141214),
        primaryContainer = Color(0xff4f378b),
        onPrimaryContainer = Color(0xffece8f5),
        secondary = Color(0xffccc2dc),
        onSecondary = Color(0xff141314),
        secondaryContainer = Color(0xff4a4458),
        onSecondaryContainer = Color(0xffebeaed),
        tertiary = Color(0xffefb8c8),
        onTertiary = Color(0xff141213),
        tertiaryContainer = Color(0xff633b48),
        onTertiaryContainer = Color(0xffefe9eb),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1a191d),
        onBackground = Color(0xffedeced),
        surface = Color(0xff1a191d),
        onSurface = Color(0xffedeced),
        surfaceVariant = Color(0xff424046),
        onSurfaceVariant = Color(0xffe1e1e1),
        outline = Color(0xff7d767d),
        outlineVariant = Color(0xff2e2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffcfbff),
        inverseOnSurface = Color(0xff131314),
        inversePrimary = Color(0xff685f77),
        surfaceTint = Color(0xffd0bcff),
    )

}