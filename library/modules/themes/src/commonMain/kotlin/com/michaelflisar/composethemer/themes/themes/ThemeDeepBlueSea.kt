package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Deep Blue Sea"
 */
object ThemeDeepBlueSea {

    const val KEY = "Deep Blue Sea"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff223a5e),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff97baea),
        onPrimaryContainer = Color(0xff0d1013),
        secondary = Color(0xff144955),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffa9edff),
        onSecondaryContainer = Color(0xff0e1414),
        tertiary = Color(0xff208399),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffccf3ff),
        onTertiaryContainer = Color(0xff111414),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8f9fa),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8f9fa),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe2e4e6),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111213),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffaabbd5),
        surfaceTint = Color(0xff223a5e),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff748bac),
        onPrimary = Color(0xfff8f9fc),
        primaryContainer = Color(0xff1b2e4b),
        onPrimaryContainer = Color(0xffe4e7eb),
        secondary = Color(0xff539eaf),
        onSecondary = Color(0xfff5fbfc),
        secondaryContainer = Color(0xff004e5d),
        onSecondaryContainer = Color(0xffdfecee),
        tertiary = Color(0xff219ab5),
        onTertiary = Color(0xfff1fbfd),
        tertiaryContainer = Color(0xff0f5b6a),
        onTertiaryContainer = Color(0xffe2eef0),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff161718),
        onBackground = Color(0xffececec),
        surface = Color(0xff161718),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff383b3e),
        onSurfaceVariant = Color(0xffdfe0e0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff7f9fa),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff404a58),
        surfaceTint = Color(0xff748bac),
    )

}