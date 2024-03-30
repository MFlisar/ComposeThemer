package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Willow And Wasabi"
 */
object ThemeWillowAndWasabi {

    const val KEY = "Willow And Wasabi"
    
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

        primary = Color(0xff738625),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffd7dfb2),
        onPrimaryContainer = Color(0xff12130f),
        secondary = Color(0xff5e3974),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xfff6d8ff),
        onSecondaryContainer = Color(0xff141214),
        tertiary = Color(0xff893789),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffd6f9),
        onTertiaryContainer = Color(0xff141214),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffbfbf9),
        onBackground = Color(0xff090909),
        surface = Color(0xfffbfbf9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe7e8e2),
        onSurfaceVariant = Color(0xff121211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff131411),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffe7f3b7),
        surfaceTint = Color(0xff738625),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffc3cb77),
        onPrimary = Color(0xff13130d),
        primaryContainer = Color(0xff586621),
        onPrimaryContainer = Color(0xffedefe4),
        secondary = Color(0xffa664cd),
        onSecondary = Color(0xfffcf6ff),
        secondaryContainer = Color(0xff61317e),
        onSecondaryContainer = Color(0xffefe7f3),
        tertiary = Color(0xffdf9adf),
        onTertiary = Color(0xff141014),
        tertiaryContainer = Color(0xff742375),
        onTertiaryContainer = Color(0xfff1e5f2),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1a1a16),
        onBackground = Color(0xffededec),
        surface = Color(0xff1a1a16),
        onSurface = Color(0xffededec),
        surfaceVariant = Color(0xff404139),
        onSurfaceVariant = Color(0xffe1e1df),
        outline = Color(0xff7d7d76),
        outlineVariant = Color(0xff2e2e2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffbfcf8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff626642),
        surfaceTint = Color(0xffc3cb77),
    )

}