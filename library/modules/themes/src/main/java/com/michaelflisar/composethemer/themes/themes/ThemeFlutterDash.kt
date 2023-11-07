package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Flutter Dash"
 */
object ThemeFlutterDash {

    fun get(
        statusBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Primary,
        navigationBarColor: ComposeTheme.SystemUIColor = ComposeTheme.SystemUIColor.Default
    ) = ComposeTheme.Theme(
        key = "Flutter Dash",
        colorSchemeLight = Light,
        colorSchemeDark = Dark,
        statusBarColor = statusBarColor,
        navigationBarColor = navigationBarColor
    )

    private val Light = lightColorScheme(

        primary = Color(0xff4496e0),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffb4e6ff),
        onPrimaryContainer = Color(0xff0f1314),
        secondary = Color(0xff202b6d),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xff99ccf9),
        onSecondaryContainer = Color(0xff0d1114),
        tertiary = Color(0xff514239),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffbaa99d),
        onTertiaryContainer = Color(0xff100e0d),
        error = Color(0xffb00020),
        onError = Color(0xffffffff),
        errorContainer = Color(0xfffcd8df),
        onErrorContainer = Color(0xff141213),
        background = Color(0xfff9fcfe),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9fcfe),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e9ed),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121416),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffddfeff),
        surfaceTint = Color(0xff4496e0),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xffb4e6ff),
        onPrimary = Color(0xff121414),
        primaryContainer = Color(0xff1e8fdb),
        onPrimaryContainer = Color(0xffe4f6ff),
        secondary = Color(0xff99ccf9),
        onSecondary = Color(0xff101414),
        secondaryContainer = Color(0xff202b6d),
        onSecondaryContainer = Color(0xffe4e6f0),
        tertiary = Color(0xffbaa99d),
        onTertiary = Color(0xff121110),
        tertiaryContainer = Color(0xff514239),
        onTertiaryContainer = Color(0xffeceae8),
        error = Color(0xffcf6679),
        onError = Color(0xff140c0d),
        errorContainer = Color(0xffb1384e),
        onErrorContainer = Color(0xfffbe8ec),
        background = Color(0xff191b1d),
        onBackground = Color(0xffeceded),
        surface = Color(0xff191b1d),
        onSurface = Color(0xffeceded),
        surfaceVariant = Color(0xff3f4446),
        onSurfaceVariant = Color(0xffe0e1e1),
        outline = Color(0xff767d7d),
        outlineVariant = Color(0xff2c2e2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffbfdff),
        inverseOnSurface = Color(0xff131314),
        inversePrimary = Color(0xff5c7177),
        surfaceTint = Color(0xffb4e6ff),
    )

}