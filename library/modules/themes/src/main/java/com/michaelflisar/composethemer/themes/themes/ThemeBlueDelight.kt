package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Blue Delight"
 */
object ThemeBlueDelight {

    const val KEY = "Blue Delight"

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

        primary = Color(0xff1565c0),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xff90caf9),
        onPrimaryContainer = Color(0xff0c1114),
        secondary = Color(0xff0277bd),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffbedcff),
        onSecondaryContainer = Color(0xff101214),
        tertiary = Color(0xff039be5),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffcbe6ff),
        onTertiaryContainer = Color(0xff111314),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff8fafd),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8fafd),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe2e6eb),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff111315),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffaedfff),
        surfaceTint = Color(0xff1565c0),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff90caf9),
        onPrimary = Color(0xff0f1314),
        primaryContainer = Color(0xff0d47a1),
        onPrimaryContainer = Color(0xffe1eaf9),
        secondary = Color(0xffe1f5fe),
        onSecondary = Color(0xff141414),
        secondaryContainer = Color(0xff1a567d),
        onSecondaryContainer = Color(0xffe3edf3),
        tertiary = Color(0xff81d4fa),
        onTertiary = Color(0xff0e1414),
        tertiaryContainer = Color(0xff004b73),
        onTertiaryContainer = Color(0xffdfebf1),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff171a1c),
        onBackground = Color(0xffeceded),
        surface = Color(0xff171a1c),
        onSurface = Color(0xffeceded),
        surfaceVariant = Color(0xff3b4146),
        onSurfaceVariant = Color(0xffe0e1e1),
        outline = Color(0xff767d7d),
        outlineVariant = Color(0xff2c2e2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9fcfe),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff4c6576),
        surfaceTint = Color(0xff90caf9),
    )

}