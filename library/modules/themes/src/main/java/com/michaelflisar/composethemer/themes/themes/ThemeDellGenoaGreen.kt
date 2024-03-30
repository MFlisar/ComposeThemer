package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColor Theme Name: "Dell Genoa Green"
 */
object ThemeDellGenoaGreen {

    const val KEY = "Dell Genoa Green"
    
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

        primary = Color(0xff386a20),
        onPrimary = Color(0xffffffff),
        primaryContainer = Color(0xffb7f397),
        onPrimaryContainer = Color(0xff0f140d),
        secondary = Color(0xff55624c),
        onSecondary = Color(0xffffffff),
        secondaryContainer = Color(0xffd9e7cb),
        onSecondaryContainer = Color(0xff121311),
        tertiary = Color(0xff19686a),
        onTertiary = Color(0xffffffff),
        tertiaryContainer = Color(0xffa8eff0),
        onTertiaryContainer = Color(0xff0e1414),
        error = Color(0xffba1a1a),
        onError = Color(0xffffffff),
        errorContainer = Color(0xffffdad6),
        onErrorContainer = Color(0xff141212),
        background = Color(0xfff9faf8),
        onBackground = Color(0xff090909),
        surface = Color(0xfff9faf8),
        onSurface = Color(0xff090909),
        surfaceVariant = Color(0xffe4e6e2),
        onSurfaceVariant = Color(0xff111211),
        outline = Color(0xff7c7c7c),
        outlineVariant = Color(0xffc8c8c8),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xff121311),
        inverseOnSurface = Color(0xfff5f5f5),
        inversePrimary = Color(0xffbbdeab),
        surfaceTint = Color(0xff386a20),
    )

    private val Dark = darkColorScheme(

        primary = Color(0xff9cd67d),
        onPrimary = Color(0xff10140d),
        primaryContainer = Color(0xff205107),
        onPrimaryContainer = Color(0xffe4ece0),
        secondary = Color(0xffbdcbb0),
        onSecondary = Color(0xff121311),
        secondaryContainer = Color(0xff3e4a36),
        onSecondaryContainer = Color(0xffe9ebe8),
        tertiary = Color(0xffa0cfd0),
        onTertiary = Color(0xff101414),
        tertiaryContainer = Color(0xff1e4e4f),
        onTertiaryContainer = Color(0xffe4ecec),
        error = Color(0xffffb4ab),
        onError = Color(0xff141211),
        errorContainer = Color(0xff93000a),
        onErrorContainer = Color(0xfff6dfe1),
        background = Color(0xff181b16),
        onBackground = Color(0xffecedec),
        surface = Color(0xff181b16),
        onSurface = Color(0xffecedec),
        surfaceVariant = Color(0xff3c4239),
        onSurfaceVariant = Color(0xffe0e1df),
        outline = Color(0xff767d76),
        outlineVariant = Color(0xff2c2e2c),

        scrim = Color(0xff000000),
        inverseSurface = Color(0xfff9fcf8),
        inverseOnSurface = Color(0xff131313),
        inversePrimary = Color(0xff526b44),
        surfaceTint = Color(0xff9cd67d),
    )

}