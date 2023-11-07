package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Verdun Green"
 */
object ThemeVerdunGreen {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Verdun Green",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff616200),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffe7e885),
        onPrimaryContainer = Color(0xff13130c),
        secondary = Color(0xff606042),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffe6e4c0),
        onSecondaryContainer = Color(0xff131310),
        tertiary = Color(0xff3d6657),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffbfecd9),
        onTertiaryContainer = Color(0xff101412),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffafaf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffafaf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe6e6e0),
        onSurfaceVariant = Color(0xff121211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff131310),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffd5d58c),
        surfaceTint = Color(0xff616200),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffcbcc58),
        onPrimary = Color(0xff13140a),
        primaryContainer = Color(0xff494a00),
        onPrimaryContainer = Color(0xffebebdf),
        secondary = Color(0xffc9c8a4),
        onSecondary = Color(0xff131310),
        secondaryContainer = Color(0xff48482d),
        onSecondaryContainer = Color(0xffebebe6),
        tertiary = Color(0xffa4d0be),
        onTertiary = Color(0xff101412),
        tertiaryContainer = Color(0xff254e40),
        onTertiaryContainer = Color(0xffe5ece9),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1a1a14),
        onBackground = Color(0xffededec),
        surface = Color(0xff1a1a14),
        onSurface = Color(0xffededec),
        surfaceVariant = Color(0xff414135),
        onSurfaceVariant = Color(0xffe1e1df),
        outline = Color(0xff7d7d76),
        outlineVariant = Color(0xff2e2e2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffcfcf6),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff666634),
        surfaceTint = Color(0xffcbcc58),
    )


}