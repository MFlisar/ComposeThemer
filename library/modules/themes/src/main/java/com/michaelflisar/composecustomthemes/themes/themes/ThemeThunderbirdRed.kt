package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Thunderbird Red"
 */
object ThemeThunderbirdRed {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Thunderbird Red",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xffbb1614),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffffdad5),
        onPrimaryContainer = Color(0xff141212),
        secondary = Color(0xff96482b),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffffdbcf),
        onSecondaryContainer = Color(0xff141211),
        tertiary = Color(0xff286294),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffd0e4ff),
        onTertiaryContainer = Color(0xff111314),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdf8f8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdf8f8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe2e2),
        onSurfaceVariant = Color(0xff121111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151111),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffaead),
        surfaceTint = Color(0xffbb1614),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffffb4aa),
        onPrimary = Color(0xff141211),
        primaryContainer = Color(0xff930006),
        onPrimaryContainer = Color(0xfff6dfe0),
        secondary = Color(0xffffb59c),
        onSecondary = Color(0xff141210),
        secondaryContainer = Color(0xff783116),
        onSecondaryContainer = Color(0xfff2e7e3),
        tertiary = Color(0xff9bcbff),
        onTertiary = Color(0xff101314),
        tertiaryContainer = Color(0xff004a79),
        onTertiaryContainer = Color(0xffdfebf2),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1d1918),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1d1918),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff463f3e),
        onSurfaceVariant = Color(0xffe1e0e0),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffffbfa),
        inverseOnSurface = Color(0xff141313),
        inversePrimary = Color(0xff775c57),
        surfaceTint = Color(0xffffb4aa),
    )

}