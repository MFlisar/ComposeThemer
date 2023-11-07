package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Green Money"
 */
object ThemeGreenMoney {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Green Money",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff264e36),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff94bda5),
        onPrimaryContainer = Color(0xff0d100e),
        secondary = Color(0xff555729),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff9ea089),
        onSecondaryContainer = Color(0xff0d0e0c),
        tertiary = Color(0xff797b3a),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffbfc0a0),
        onTertiaryContainer = Color(0xff10100e),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff9faf9),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9faf9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe3e5e3),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111212),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffabc8b7),
        surfaceTint = Color(0xff264e36),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff7ab893),
        onPrimary = Color(0xff0d120f),
        primaryContainer = Color(0xff224430),
        onPrimaryContainer = Color(0xffe5eae7),
        secondary = Color(0xffbbbe74),
        onSecondary = Color(0xff12120d),
        secondaryContainer = Color(0xff404204),
        onSecondaryContainer = Color(0xffe9eae0),
        tertiary = Color(0xffd5d6a8),
        onTertiary = Color(0xff141411),
        tertiaryContainer = Color(0xff515402),
        onTertiaryContainer = Color(0xffecece0),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff161917),
        onBackground = Color(0xffececec),
        surface = Color(0xff161917),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff393f3b),
        onSurfaceVariant = Color(0xffdfe0e0),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff8fbf9),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff435d4d),
        surfaceTint = Color(0xff7ab893),
    )

}