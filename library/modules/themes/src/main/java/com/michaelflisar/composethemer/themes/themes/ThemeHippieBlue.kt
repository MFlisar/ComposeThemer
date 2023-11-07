package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Hippie Blue"
 */
object ThemeHippieBlue {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Hippie Blue",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff4c9bba),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff9cebeb),
        onPrimaryContainer = Color(0xff0d1414),
        secondary = Color(0xffbf4a50),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xfffcbdbd),
        onSecondaryContainer = Color(0xff141010),
        tertiary = Color(0xffff4f58),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffdad7),
        onTertiaryContainer = Color(0xff141212),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfffafcfd),
        onBackground = Color(0xff090909),
        surface = Color(0xfffafcfd),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe5e9eb),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121415),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffe5ffff),
        surfaceTint = Color(0xff4c9bba),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff669db3),
        onPrimary = Color(0xfff7fbfd),
        primaryContainer = Color(0xff078282),
        onPrimaryContainer = Color(0xffe0f4f4),
        secondary = Color(0xfff75f67),
        onSecondary = Color(0xfffff6f7),
        secondaryContainer = Color(0xff580810),
        onSecondaryContainer = Color(0xffede1e2),
        tertiary = Color(0xfffc6e75),
        onTertiary = Color(0xfffff7f8),
        tertiaryContainer = Color(0xff92001a),
        onTertiaryContainer = Color(0xfff6dfe3),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff151819),
        onBackground = Color(0xffececec),
        surface = Color(0xff151819),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff373c3f),
        onSurfaceVariant = Color(0xffdfe0e0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff7fafb),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff3a525b),
        surfaceTint = Color(0xff669db3),
    )

}