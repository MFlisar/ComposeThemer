package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Deep Purple"
 */
object ThemeDeepPurple {

    const val KEY = "Deep Purple"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff4527a0),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffd1c4e9),
        onPrimaryContainer = Color(0xff111013),
        secondary = Color(0xff00b0ff),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xff9fcbf1),
        onSecondaryContainer = Color(0xff0e1114),
        tertiary = Color(0xff0091ea),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffcfe4ff),
        onTertiaryContainer = Color(0xff111314),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9f9fc),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9f9fc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e3e9),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121114),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffd1c0ff),
        surfaceTint = Color(0xff4527a0),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffb39ddb),
        onPrimary = Color(0xff121014),
        primaryContainer = Color(0xff7e57c2),
        onPrimaryContainer = Color(0xfff3edfe),
        secondary = Color(0xff40c4ff),
        onSecondary = Color(0xff091314),
        secondaryContainer = Color(0xff0179b6),
        onSecondaryContainer = Color(0xffdff2fc),
        tertiary = Color(0xff80d8ff),
        onTertiary = Color(0xff0e1414),
        tertiaryContainer = Color(0xff00497b),
        onTertiaryContainer = Color(0xffdfebf3),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff19181b),
        onBackground = Color(0xffececed),
        surface = Color(0xff19181b),
        onSurface = Color(0xffececed),
        surfaceVariant = Color(0xff3f3c43),
        onSurfaceVariant = Color(0xffe0e0e1),
        outline = Color(0xff76767d),
        outlineVariant = Color(0xff2c2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffbfafd),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff5b526d),
        surfaceTint = Color(0xffb39ddb),
    )

}