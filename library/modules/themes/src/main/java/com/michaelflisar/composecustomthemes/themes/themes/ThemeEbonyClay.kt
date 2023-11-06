package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Ebony Clay"
 */
object ThemeEbonyClay {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Ebony Clay",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff202541),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff9ba7cf),
        onPrimaryContainer = Color(0xff0d0e11),
        secondary = Color(0xff004b3b),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff82bcb5),
        onSecondaryContainer = Color(0xff0b100f),
        tertiary = Color(0xff006b54),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xff8fc3ad),
        onTertiaryContainer = Color(0xff0c100f),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8f9f9),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8f9f9),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe2e2e4),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111112),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffa4a7bc),
        surfaceTint = Color(0xff202541),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff4e597d),
        onPrimary = Color(0xfff5f5f8),
        primaryContainer = Color(0xff202541),
        onPrimaryContainer = Color(0xffe4e5e9),
        secondary = Color(0xff3d8475),
        onSecondary = Color(0xfff3f9f8),
        secondaryContainer = Color(0xff063f36),
        onSecondaryContainer = Color(0xffe0e9e8),
        tertiary = Color(0xff4ba390),
        onTertiary = Color(0xfff4fbfa),
        tertiaryContainer = Color(0xff0b5341),
        onTertiaryContainer = Color(0xffe1ece9),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff141416),
        onBackground = Color(0xffececec),
        surface = Color(0xff141416),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff343539),
        onSurfaceVariant = Color(0xffdfdfdf),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff5f6f8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff303444),
        surfaceTint = Color(0xff4e597d),
    )

}