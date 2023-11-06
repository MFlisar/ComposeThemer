package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Blue Whale"
 */
object ThemeBlueWhale {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Blue Whale",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff023047),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff8edbce),
        onPrimaryContainer = Color(0xff0c1211),
        secondary = Color(0xfff07e24),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffffbf93),
        onSecondaryContainer = Color(0xff14100d),
        tertiary = Color(0xfff86541),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffad91),
        onTertiaryContainer = Color(0xff140f0c),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8f9f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8f9f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe1e3e4),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101112),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xff89adbf),
        surfaceTint = Color(0xff023047),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff57859d),
        onPrimary = Color(0xfff5f9fb),
        primaryContainer = Color(0xff2a9d8f),
        onPrimaryContainer = Color(0xffe6f8f6),
        secondary = Color(0xffed7f29),
        onSecondary = Color(0xfffff8f2),
        secondaryContainer = Color(0xff994600),
        onSecondaryContainer = Color(0xfff7eadf),
        tertiary = Color(0xffff6e48),
        onTertiary = Color(0xfffff7f4),
        tertiaryContainer = Color(0xffa3290f),
        onTertiaryContainer = Color(0xfff9e6e2),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff141618),
        onBackground = Color(0xffececec),
        surface = Color(0xff141618),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff353a3c),
        onSurfaceVariant = Color(0xffdfe0e0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff6f8fa),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff344752),
        surfaceTint = Color(0xff57859d),
    )

}