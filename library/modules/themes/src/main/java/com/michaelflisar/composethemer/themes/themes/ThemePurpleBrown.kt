package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Purple Brown"
 */
object ThemePurpleBrown {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Purple Brown",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff450a0f),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffb9a6a8),
        onPrimaryContainer = Color(0xff100e0e),
        secondary = Color(0xff4a0635),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffe3b0c5),
        onSecondaryContainer = Color(0xff130f11),
        tertiary = Color(0xff60234f),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffe9cedd),
        onTertiaryContainer = Color(0xff131112),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9f8f8),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9f8f8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e1e1),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121010),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffbe9094),
        surfaceTint = Color(0xff450a0f),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffa98085),
        onPrimary = Color(0xfffcf9f9),
        primaryContainer = Color(0xff682a2c),
        onPrimaryContainer = Color(0xfff0e6e6),
        secondary = Color(0xff5f4c5a),
        onSecondary = Color(0xfff6f4f6),
        secondaryContainer = Color(0xff501a3c),
        onSecondaryContainer = Color(0xffece3e9),
        tertiary = Color(0xff975384),
        onTertiary = Color(0xfffaf5f9),
        tertiaryContainer = Color(0xff6a2357),
        onTertiaryContainer = Color(0xfff0e5ed),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff181616),
        onBackground = Color(0xffececec),
        surface = Color(0xff181616),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff3e393a),
        onSurfaceVariant = Color(0xffe0dfe0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffaf8f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff574547),
        surfaceTint = Color(0xffa98085),
    )

}