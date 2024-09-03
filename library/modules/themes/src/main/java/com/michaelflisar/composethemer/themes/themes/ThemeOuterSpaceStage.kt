package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Outer Space Stage"
 */
object ThemeOuterSpaceStage {

    const val KEY = "Outer Space Stage"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff1f3339),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff9ec4d4),
        onPrimaryContainer = Color(0xff0d1012),
        secondary = Color(0xff93a0a9),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xffb5cddb),
        onSecondaryContainer = Color(0xff0f1112),
        tertiary = Color(0xffd2600a),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffdbc8),
        onTertiaryContainer = Color(0xff141211),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8f9f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8f9f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe2e3e4),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111112),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffa2b1b5),
        surfaceTint = Color(0xff1f3339),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff486a71),
        onPrimary = Color(0xfff4f7f7),
        primaryContainer = Color(0xff1f3339),
        onPrimaryContainer = Color(0xffe4e7e8),
        secondary = Color(0xffaab4bb),
        onSecondary = Color(0xff111212),
        secondaryContainer = Color(0xff285c71),
        onSecondaryContainer = Color(0xffe6eef1),
        tertiary = Color(0xffdb823f),
        onTertiary = Color(0xfffff9f3),
        tertiaryContainer = Color(0xffc05402),
        onTertiaryContainer = Color(0xfffdece0),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff131515),
        onBackground = Color(0xffececec),
        surface = Color(0xff131515),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff343738),
        onSurfaceVariant = Color(0xffdfdfdf),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff5f7f7),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff2d3c3f),
        surfaceTint = Color(0xff486a71),
    )

}