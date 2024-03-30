package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Greens"
 */
object ThemeGreens {

    const val KEY = "Greens"
    
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
        primary = Color(0xff065808),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff9ee29f),
        onPrimaryContainer = Color(0xff0d130e),
        secondary = Color(0xff365b37),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffaebdaf),
        onSecondaryContainer = Color(0xff0f100f),
        tertiary = Color(0xff2c7e2e),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffb8e6b9),
        onTertiaryContainer = Color(0xff101310),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8faf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8faf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe1e5e1),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),
        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101210),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xff8fce91),
        surfaceTint = Color(0xff065808)
    )

    private val Dark = darkColorScheme(
        primary = Color(0xff629f80),
        onPrimary = Color(0xfff6fbf9),
        primaryContainer = Color(0xff274033),
        onPrimaryContainer = Color(0xffe5e9e7),
        secondary = Color(0xff81b39a),
        onSecondary = Color(0xff0e1210),
        secondaryContainer = Color(0xff4d6b5c),
        onSecondaryContainer = Color(0xffebf0ee),
        tertiary = Color(0xff88c5a6),
        onTertiary = Color(0xff0e1311),
        tertiaryContainer = Color(0xff356c50),
        onTertiaryContainer = Color(0xffe8f0ec),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff151816),
        onBackground = Color(0xffececec),
        surface = Color(0xff151816),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff363d39),
        onSurfaceVariant = Color(0xffdfe0df),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),
        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff6faf8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff395345),
        surfaceTint = Color(0xff629f80)
    )

}