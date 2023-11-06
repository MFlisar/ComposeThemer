package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Indigo Nights"
 */
object ThemeIndigoNights {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Indigo Nights",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff303f9f),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffaeb9f4),
        onPrimaryContainer = Color(0xff0f1014),
        secondary = Color(0xff512da8),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffe9ddff),
        onSecondaryContainer = Color(0xff131214),
        tertiary = Color(0xff311b92),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffd1c5ff),
        onTertiaryContainer = Color(0xff111114),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9f9fc),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9f9fc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e4e9),
        onSurfaceVariant = Color(0xff111112),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111214),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffc9d1ff),
        surfaceTint = Color(0xff303f9f),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff7986cb),
        onPrimary = Color(0xfff8f9fe),
        primaryContainer = Color(0xff283593),
        onPrimaryContainer = Color(0xffe6e8f6),
        secondary = Color(0xff9575cd),
        onSecondary = Color(0xfffaf8ff),
        secondaryContainer = Color(0xff502ca7),
        onSecondaryContainer = Color(0xffece6f9),
        tertiary = Color(0xff7e57c2),
        onTertiary = Color(0xfff8f5fe),
        tertiaryContainer = Color(0xff4433a4),
        onTertiaryContainer = Color(0xffeae7f9),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff16161a),
        onBackground = Color(0xffececed),
        surface = Color(0xff16161a),
        onSurface = Color(0xffececed),
        surfaceVariant = Color(0xff393a41),
        onSurfaceVariant = Color(0xffdfe0e1),
        outline = Color(0xff76767d),
        outlineVariant = Color(0xff2c2c2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff8f8fc),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff424866),
        surfaceTint = Color(0xff7986cb),
    )

}