package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Indigo San Marino"
 */
object ThemeIndigoSanMarino {

    const val KEY = "Indigo San Marino"
    
    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff4355b9),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffdee0ff),
        onPrimaryContainer = Color(0xff121314),
        secondary = Color(0xff3c64ae),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffd8e2ff),
        onSecondaryContainer = Color(0xff121314),
        tertiary = Color(0xff537577),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffa9d4d6),
        onTertiaryContainer = Color(0xff0e1212),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff9fafd),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9fafd),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e5eb),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121215),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffdce3ff),
        surfaceTint = Color(0xff4355b9),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffbac3ff),
        onPrimary = Color(0xff121314),
        primaryContainer = Color(0xff293ca0),
        onPrimaryContainer = Color(0xffe6e9f8),
        secondary = Color(0xffaec6ff),
        onSecondary = Color(0xff111314),
        secondaryContainer = Color(0xff14448d),
        onSecondaryContainer = Color(0xffe2eaf5),
        tertiary = Color(0xffa9cdcf),
        onTertiary = Color(0xff111414),
        tertiaryContainer = Color(0xff2a4c4e),
        onTertiaryContainer = Color(0xffe6ebec),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff191a1d),
        onBackground = Color(0xffeceded),
        surface = Color(0xff191a1d),
        onSurface = Color(0xffeceded),
        surfaceVariant = Color(0xff3f4046),
        onSurfaceVariant = Color(0xffe0e1e1),
        outline = Color(0xff767d7d),
        outlineVariant = Color(0xff2c2e2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffbfbff),
        inverseOnSurface = Color(0xff131314),
        inversePrimary = Color(0xff5e6277),
        surfaceTint = Color(0xffbac3ff),
    )

}