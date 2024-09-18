package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Gold Sunset"
 */
object ThemeGoldSunset {

    const val KEY = "Gold Sunset"
    
    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(

        primary = Color(0xffb86914),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xfff2c18c),
        onPrimaryContainer = Color(0xff14100c),
        secondary = Color(0xffb36832),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffca9d7c),
        onSecondaryContainer = Color(0xff110d0b),
        tertiary = Color(0xffef6c00),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffbe93),
        onTertiaryContainer = Color(0xff14100d),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfffdfaf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfffdfaf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffebe6e2),
        onSurfaceVariant = Color(0xff121211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff151311),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffffe1ad),
        surfaceTint = Color(0xffb86914),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffeda85e),
        onPrimary = Color(0xff14110b),
        primaryContainer = Color(0xffb86914),
        onPrimaryContainer = Color(0xfffcf0e2),
        secondary = Color(0xffddab88),
        onSecondary = Color(0xff14110e),
        secondaryContainer = Color(0xffbf7d4e),
        onSecondaryContainer = Color(0xfffdf3ec),
        tertiary = Color(0xffd28f60),
        onTertiary = Color(0xff140f0b),
        tertiaryContainer = Color(0xffb5642c),
        onTertiaryContainer = Color(0xfffcefe6),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1c1814),
        onBackground = Color(0xffedecec),
        surface = Color(0xff1c1814),
        onSurface = Color(0xffedecec),
        surfaceVariant = Color(0xff453e36),
        onSurfaceVariant = Color(0xffe1e0df),
        outline = Color(0xff7d7676),
        outlineVariant = Color(0xff2e2c2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffefaf6),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff745636),
        surfaceTint = Color(0xffeda85e),
    )

}