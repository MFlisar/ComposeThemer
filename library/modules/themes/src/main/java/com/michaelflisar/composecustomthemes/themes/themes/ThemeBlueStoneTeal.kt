package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Blue Stone Teal"
 */
object ThemeBlueStoneTeal {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Blue Stone Teal",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff006a60),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffbbede6),
        onPrimaryContainer = Color(0xff101413),
        secondary = Color(0xff4a635f),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffcce8e2),
        onSecondaryContainer = Color(0xff111313),
        tertiary = Color(0xff48617a),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffcfe5ff),
        onTertiaryContainer = Color(0xff111314),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff8fafa),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8fafa),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe0e6e6),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101313),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xff8ddcd5),
        surfaceTint = Color(0xff006a60),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff53dbca),
        onPrimary = Color(0xff0a1413),
        primaryContainer = Color(0xff005048),
        onPrimaryContainer = Color(0xffdfeceb),
        secondary = Color(0xffaeccce),
        onSecondary = Color(0xff111414),
        secondaryContainer = Color(0xff304b4d),
        onSecondaryContainer = Color(0xffe7ebeb),
        tertiary = Color(0xffc0c3ef),
        onTertiary = Color(0xff131314),
        tertiaryContainer = Color(0xff404468),
        onTertiaryContainer = Color(0xffe9eaf0),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff141b1a),
        onBackground = Color(0xffeceded),
        surface = Color(0xff141b1a),
        onSurface = Color(0xffeceded),
        surfaceVariant = Color(0xff354341),
        onSurfaceVariant = Color(0xffdfe1e1),
        outline = Color(0xff767d7d),
        outlineVariant = Color(0xff2c2e2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff6fdfc),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff326d65),
        surfaceTint = Color(0xff53dbca),
    )

}