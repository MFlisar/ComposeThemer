package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Lipstick Pink"
 */
object ThemeLipstickPink {

    const val KEY = "Lipstick Pink"

    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xffbc004b),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffffd9de),
        onPrimaryContainer = Color(0xff141212),
        secondary = Color(0xff9b4050),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xfff8c7cb),
        onSecondaryContainer = Color(0xff141111),
        tertiary = Color(0xff874978),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffd7f0),
        onTertiaryContainer = Color(0xff141214),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdf8fa),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdf8fa),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe0e5),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151012),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffff99cb),
        surfaceTint = Color(0xffbc004b),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffffb2be),
        onPrimary = Color(0xff141112),
        primaryContainer = Color(0xff900038),
        onPrimaryContainer = Color(0xfff6dfe8),
        secondary = Color(0xffffd9dc),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xff5f1224),
        onSecondaryContainer = Color(0xffeee2e5),
        tertiary = Color(0xfffaafe4),
        onTertiary = Color(0xff141114),
        tertiaryContainer = Color(0xff6b325f),
        onTertiaryContainer = Color(0xfff0e7ee),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1d1919),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1d1919),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff463f40),
        onSurfaceVariant = Color(0xffe1e0e1),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffffbfb),
        inverseOnSurface = Color(0xff141313),
        inversePrimary = Color(0xff775b60),
        surfaceTint = Color(0xffffb2be),
    )

}