package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Rust Deep Orange"
 */
object ThemeRustDeepOrange {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Rust Deep Orange",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xffbf360c),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffffdbd1),
        onPrimaryContainer = Color(0xff141211),
        secondary = Color(0xffbe593b),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffffede8),
        onSecondaryContainer = Color(0xff141413),
        tertiary = Color(0xff466827),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffc6ef9f),
        onTertiaryContainer = Color(0xff11140e),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdf9f8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdf9f8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe3e1),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151210),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffc0a5),
        surfaceTint = Color(0xffbf360c),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffffb5a0),
        onPrimary = Color(0xff141210),
        primaryContainer = Color(0xff862200),
        onPrimaryContainer = Color(0xfff4e5df),
        secondary = Color(0xffffdbd1),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xff5f1600),
        onSecondaryContainer = Color(0xffeee3df),
        tertiary = Color(0xffabd285),
        onTertiary = Color(0xff11140e),
        tertiaryContainer = Color(0xff2f4f11),
        onTertiaryContainer = Color(0xffe7ece2),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1d1918),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1d1918),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff463f3d),
        onSurfaceVariant = Color(0xffe1e0e0),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffffbfa),
        inverseOnSurface = Color(0xff141313),
        inversePrimary = Color(0xff775c53),
        surfaceTint = Color(0xffffb5a0),
    )

}