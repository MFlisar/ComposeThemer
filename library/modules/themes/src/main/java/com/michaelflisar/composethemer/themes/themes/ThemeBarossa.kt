package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Barossa"
 */
object ThemeBarossa {

    const val KEY = "Barossa"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xff4e0029),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffbda5b1),
        onPrimaryContainer = Color(0xff100e0f),
        secondary = Color(0xff00341a),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff8dc1a8),
        onSecondaryContainer = Color(0xff0c100e),
        tertiary = Color(0xff124c2f),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffa4d9bf),
        onTertiaryContainer = Color(0xff0e1210),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffaf8f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfffaf8f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe5e0e3),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121011),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffc588a8),
        surfaceTint = Color(0xff4e0029),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff94667e),
        onPrimary = Color(0xfffaf7f8),
        primaryContainer = Color(0xff4e0029),
        onPrimaryContainer = Color(0xffecdfe6),
        secondary = Color(0xff6b9882),
        onSecondary = Color(0xfff7faf9),
        secondaryContainer = Color(0xff21614c),
        onSecondaryContainer = Color(0xffe4efeb),
        tertiary = Color(0xff599b7b),
        onTertiary = Color(0xfff5fbf8),
        tertiaryContainer = Color(0xff1d5330),
        onTertiaryContainer = Color(0xffe4ece7),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff171516),
        onBackground = Color(0xffececec),
        surface = Color(0xff171516),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff3b3739),
        onSurfaceVariant = Color(0xffe0dfdf),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9f7f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff4e3a44),
        surfaceTint = Color(0xff94667e),
    )

}