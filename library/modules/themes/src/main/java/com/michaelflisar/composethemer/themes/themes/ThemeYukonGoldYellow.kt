package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Yukon Gold Yellow"
 */
object ThemeYukonGoldYellow {

    const val KEY = "Yukon Gold Yellow"
    
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

        primary = Color(0xff695f00),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xfff3e47f),
        onPrimaryContainer = Color(0xff14130b),
        secondary = Color(0xff7c7b16),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xfff8f591),
        onSecondaryContainer = Color(0xff14140c),
        tertiary = Color(0xff375f97),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffd5e3ff),
        onTertiaryContainer = Color(0xff121314),
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
        inversePrimary = Color(0xffdbd48d),
        surfaceTint = Color(0xff695f00),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffd8c84f),
        onPrimary = Color(0xff14130a),
        primaryContainer = Color(0xff4f4700),
        onPrimaryContainer = Color(0xffeceadf),
        secondary = Color(0xffe9e784),
        onSecondary = Color(0xff14140e),
        secondaryContainer = Color(0xff333200),
        onSecondaryContainer = Color(0xffe7e7df),
        tertiary = Color(0xffa7c8ff),
        onTertiary = Color(0xff111314),
        tertiaryContainer = Color(0xff1b477e),
        onTertiaryContainer = Color(0xffe4eaf3),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff1b1a14),
        onBackground = Color(0xffededec),
        surface = Color(0xff1b1a14),
        onSurface = Color(0xffededec),
        surfaceVariant = Color(0xff424134),
        onSurfaceVariant = Color(0xffe1e1df),
        outline = Color(0xff7d7d76),
        outlineVariant = Color(0xff2e2e2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffdfcf6),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff6b6430),
        surfaceTint = Color(0xffd8c84f),
    )

}