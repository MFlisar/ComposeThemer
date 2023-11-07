package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Grey Law"
 */
object ThemeGreyLaw {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Grey Law",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff37474f),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffb0bec5),
        onPrimaryContainer = Color(0xff0f1011),
        secondary = Color(0xff2c314f),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffdde0ff),
        onSecondaryContainer = Color(0xff121314),
        tertiary = Color(0xff521d82),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xfff1daff),
        onTertiaryContainer = Color(0xff141214),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff9f9fa),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9f9fa),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e4e5),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121212),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffbac5cb),
        surfaceTint = Color(0xff37474f),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff90a4ae),
        onPrimary = Color(0xff0f1011),
        primaryContainer = Color(0xff37474f),
        onPrimaryContainer = Color(0xffe8eaec),
        secondary = Color(0xff373d5c),
        onSecondary = Color(0xfff3f3f6),
        secondaryContainer = Color(0xff1d2449),
        onSecondaryContainer = Color(0xffe4e5eb),
        tertiary = Color(0xff815aa3),
        onTertiary = Color(0xfff9f6fb),
        tertiaryContainer = Color(0xff421f62),
        onTertiaryContainer = Color(0xffeae4ef),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff171819),
        onBackground = Color(0xffececec),
        surface = Color(0xff171819),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff3b3d3e),
        onSurfaceVariant = Color(0xffe0e0e0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9fafa),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff4c5559),
        surfaceTint = Color(0xff90a4ae),
    )


}