package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Damask And Lunar"
 */
object ThemeDamaskAndLunar {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Damask And Lunar",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xffc96646),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffecc9bd),
        onPrimaryContainer = Color(0xff141110),
        secondary = Color(0xff373a36),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff9eab9f),
        onSecondaryContainer = Color(0xff0d0e0e),
        tertiary = Color(0xff343e32),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xff94b291),
        onTertiaryContainer = Color(0xff0d0f0c),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffdfaf9),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdfaf9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe6e4),
        onSurfaceVariant = Color(0xff121211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff161312),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffebdf),
        surfaceTint = Color(0xffc96646),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffda9882),
        onPrimary = Color(0xff140f0e),
        primaryContainer = Color(0xffc96646),
        onPrimaryContainer = Color(0xffffefea),
        secondary = Color(0xff767d75),
        onSecondary = Color(0xfff8f8f8),
        secondaryContainer = Color(0xff3a5444),
        onSecondaryContainer = Color(0xffe8ecea),
        tertiary = Color(0xff839081),
        onTertiary = Color(0xfff9faf9),
        tertiaryContainer = Color(0xff34553e),
        onTertiaryContainer = Color(0xffe7ede9),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1b1716),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1b1716),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff433c3a),
        onSurfaceVariant = Color(0xffe1e0e0),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffdf9f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff6c4f46),
        surfaceTint = Color(0xffda9882),
    )

}