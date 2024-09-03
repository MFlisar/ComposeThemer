package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Brown Orange"
 */
object ThemeBrownOrange {

    const val KEY = "Brown Orange"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff8b5000),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffffdcbe),
        onPrimaryContainer = Color(0xff141210),
        secondary = Color(0xffb6602f),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffffede6),
        onSecondaryContainer = Color(0xff141413),
        tertiary = Color(0xff466827),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffc6ef9f),
        onTertiaryContainer = Color(0xff11140e),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffbfaf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffbfaf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe8e5e0),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff141210),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xfff5cc95),
        surfaceTint = Color(0xff8b5000),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffffb871),
        onPrimary = Color(0xff14120c),
        primaryContainer = Color(0xff6a3c00),
        onPrimaryContainer = Color(0xfff0e9df),
        secondary = Color(0xffffdbcb),
        onSecondary = Color(0xff141413),
        secondaryContainer = Color(0xff552000),
        onSecondaryContainer = Color(0xffede4df),
        tertiary = Color(0xffabd285),
        onTertiary = Color(0xff11140e),
        tertiaryContainer = Color(0xff2f4f11),
        onTertiaryContainer = Color(0xffe7ece2),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1d1915),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1d1915),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff463f38),
        onSurfaceVariant = Color(0xffe1e0df),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffffbf7),
        inverseOnSurface = Color(0xff141313),
        inversePrimary = Color(0xff775d3f),
        surfaceTint = Color(0xffffb871),
    )

}