package com.michaelflisar.composecustomthemes.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composecustomtheme.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Green Jungle"
 */
object ThemeGreenJungle {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Green Jungle",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff004e15),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff8fb99b),
        onPrimaryContainer = Color(0xff0c100d),
        secondary = Color(0xff295300),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff8faa78),
        onSecondaryContainer = Color(0xff0c0e0a),
        tertiary = Color(0xff007256),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xff83bcad),
        onTertiaryContainer = Color(0xff0b100f),
        error = Color(0xff790000),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfff1d8d8),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff8faf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8faf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe0e5e2),
        onSurfaceVariant = Color(0xff111111),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101211),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xff88c599),
        surfaceTint = Color(0xff004e15),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff519e67),
        onPrimary = Color(0xfff5fbf7),
        primaryContainer = Color(0xff27683a),
        onPrimaryContainer = Color(0xffe5f0e8),
        secondary = Color(0xff73a497),
        onSecondary = Color(0xfff8fbfa),
        secondaryContainer = Color(0xff275000),
        onSecondaryContainer = Color(0xffe5ecdf),
        tertiary = Color(0xff479985),
        onTertiary = Color(0xfff4fbf9),
        tertiaryContainer = Color(0xff00513b),
        onTertiaryContainer = Color(0xffdfece9),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff141815),
        onBackground = Color(0xffececec),
        surface = Color(0xff141815),
        onSurface = Color(0xffececec),
        surfaceVariant = Color(0xff353d37),
        onSurfaceVariant = Color(0xffdfe0df),
        outline = Color(0xff797979),
        outlineVariant = Color(0xff2d2d2d),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff6faf7),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff31523b),
        surfaceTint = Color(0xff519e67),
    )

}