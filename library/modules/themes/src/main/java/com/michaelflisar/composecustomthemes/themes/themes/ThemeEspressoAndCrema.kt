package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Espresso And Crema"
 */
object ThemeEspressoAndCrema {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Espresso And Crema",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff452f2b),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffc7bcac),
        onPrimaryContainer = Color(0xff11100f),
        secondary = Color(0xfff5e9c9),
        onSecondary = Color(0xff000000),
        secondaryContainer = Color(0xfffee7ad),
        onSecondaryContainer = Color(0xff14130f),
        tertiary = Color(0xffe3b964),
        onTertiary = Color(0xff000000),
        tertiaryContainer = Color(0xffffde9c),
        onTertiaryContainer = Color(0xff14120d),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9f9f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9f9f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e3e3),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121111),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffc1b1ae),
        surfaceTint = Color(0xff452f2b),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff8d7f7d),
        onPrimary = Color(0xfffaf8f8),
        primaryContainer = Color(0xff452f2b),
        onPrimaryContainer = Color(0xffeae7e6),
        secondary = Color(0xfff8ecd4),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xff705d49),
        onSecondaryContainer = Color(0xfff1eeeb),
        tertiary = Color(0xffeed6a6),
        onTertiary = Color(0xff141411),
        tertiaryContainer = Color(0xff8e774f),
        onTertiaryContainer = Color(0xfff6f2ec),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff171616),
        onBackground = Color(0xffececec),
        surface = Color(0xff171616),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff3b3939),
        onSurfaceVariant = Color(0xffe0dfdf),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9f8f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff4b4544),
        surfaceTint = Color(0xff8d7f7d),
    )

}