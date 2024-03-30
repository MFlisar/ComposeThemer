package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Endeavour Blue"
 */
object ThemeEndeavourBlue {

    const val KEY = "Endeavour Blue"
    
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

        primary = Color(0xff0061a4),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffd1e4ff),
        onPrimaryContainer = Color(0xff111314),
        secondary = Color(0xff006781),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffb9eaff),
        onSecondaryContainer = Color(0xff101314),
        tertiary = Color(0xffa73a00),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffffdbce),
        onTertiaryContainer = Color(0xff141211),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff8fafc),
        onBackground = Color(0xff090909),
        surface = Color(0xfff8fafc),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe0e6e9),
        onSurfaceVariant = Color(0xff111212),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff101315),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xff99daff),
        surfaceTint = Color(0xff0061a4),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff9ecaff),
        onPrimary = Color(0xff101314),
        primaryContainer = Color(0xff00497d),
        onPrimaryContainer = Color(0xffdfebf3),
        secondary = Color(0xff86d1ee),
        onSecondary = Color(0xff0e1414),
        secondaryContainer = Color(0xff004d62),
        onSecondaryContainer = Color(0xffdfebef),
        tertiary = Color(0xffffb599),
        onTertiary = Color(0xff141210),
        tertiaryContainer = Color(0xff802a00),
        onTertiaryContainer = Color(0xfff3e6df),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff181a1d),
        onBackground = Color(0xffeceded),
        surface = Color(0xff181a1d),
        onSurface = Color(0xffeceded),
        surfaceVariant = Color(0xff3d4146),
        onSurfaceVariant = Color(0xffe0e1e1),
        outline = Color(0xff767d7d),
        outlineVariant = Color(0xff2c2e2e),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfffafcff),
        inverseOnSurface = Color(0xff131314),
        inversePrimary = Color(0xff526577),
        surfaceTint = Color(0xff9ecaff),
    )

}