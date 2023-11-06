package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "RedAndBlue"
 */
object ThemeRedAndBlue {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Red And Blue",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(
        primary = Color(0xff1145a4),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffacc7f6),
        onPrimaryContainer = Color(0xff0f1114),
        secondary = Color(0xff376bca),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffcfdbf2),
        onSecondaryContainer = Color(0xff111214),
        tertiary = Color(0xffb61d1d),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffec9f9f),
        onTertiaryContainer = Color(0xff140e0e),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8f9fc),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8f9fc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe1e4e9),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),
        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111215),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffaacbff),
        surfaceTint = Color(0xff1145a4)
    )

    private val Dark = darkColorScheme(
        primary = Color(0xffc4d7f8),
        onPrimary = Color(0xff131414),
        primaryContainer = Color(0xff577cbf),
        onPrimaryContainer = Color(0xffedf3fd),
        secondary = Color(0xffdde5f5),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xff7297d9),
        onSecondaryContainer = Color(0xfff1f7ff),
        tertiary = Color(0xfff1bbbb),
        onTertiary = Color(0xff141212),
        tertiaryContainer = Color(0xffcb6060),
        onTertiaryContainer = Color(0xffffeeee),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff1a1b1c),
        onBackground = Color(0xffededed),
        surface = Color(0xff1a1b1c),
        onSurface = Color(0xffededed),
        surfaceVariant = Color(0xff404246),
        onSurfaceVariant = Color(0xffe1e1e1),
        outline = Color(0xff7a7a7a),
        outlineVariant = Color(0xff2e2e2e),
        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffbfcfe),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff636b76),
        surfaceTint = Color(0xffc4d7f8)
    )
}