package com.michaelflisar.composethemer.themes.themes

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeTheme

/**
 * Theme taken from the default themes from https://rydmike.com/flexcolorscheme/themesplayground-latest/
 *
 * FlexColorScheme v8.0.2
 *
 * FlexColor Theme Name: "Midnight"
 */
object ThemeYukonGoldYellow {

    const val KEY = "Yukon Gold Yellow"

    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(
        primary = Color(0xFF695F00),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFF3E47F),
        onPrimaryContainer = Color(0xFF000000),
        secondary = Color(0xFF7C7B16),
        onSecondary = Color(0xFFFFFFFF),
        secondaryContainer = Color(0xFFF8F591),
        onSecondaryContainer = Color(0xFF000000),
        tertiary = Color(0xFF375F97),
        onTertiary = Color(0xFFFFFFFF),
        tertiaryContainer = Color(0xFFD5E3FF),
        onTertiaryContainer = Color(0xFF000000),
        error = Color(0xFFBA1A1A),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFFFDAD6),
        onErrorContainer = Color(0xFF000000),
        surface = Color(0xFFFCFCFC),
        onSurface = Color(0xFF111111),
        surfaceDim = Color(0xFFE0E0E0),
        surfaceBright = Color(0xFFFDFDFD),
        surfaceContainerLowest = Color(0xFFFFFFFF),
        surfaceContainerLow = Color(0xFFF8F8F8),
        surfaceContainer = Color(0xFFF3F3F3),
        surfaceContainerHigh = Color(0xFFEDEDED),
        surfaceContainerHighest = Color(0xFFE7E7E7),
        onSurfaceVariant = Color(0xFF393939),
        outline = Color(0xFF919191),
        outlineVariant = Color(0xFFD1D1D1),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFF2A2A2A),
        inverseOnSurface = Color(0xFFF1F1F1),
        inversePrimary = Color(0xFFDBD48D),
    )

    private val Dark = darkColorScheme(
        primary = Color(0xFFD8C84F),
        onPrimary = Color(0xFF000000),
        primaryContainer = Color(0xFF4F4700),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFFE9E784),
        onSecondary = Color(0xFF000000),
        secondaryContainer = Color(0xFF333200),
        onSecondaryContainer = Color(0xFFFFFFFF),
        tertiary = Color(0xFFA7C8FF),
        onTertiary = Color(0xFF000000),
        tertiaryContainer = Color(0xFF1B477E),
        onTertiaryContainer = Color(0xFFFFFFFF),
        error = Color(0xFFFFB4AB),
        onError = Color(0xFF000000),
        errorContainer = Color(0xFF93000A),
        onErrorContainer = Color(0xFFFFFFFF),
        surface = Color(0xFF080808),
        onSurface = Color(0xFFF1F1F1),
        surfaceDim = Color(0xFF060606),
        surfaceBright = Color(0xFF2C2C2C),
        surfaceContainerLowest = Color(0xFF010101),
        surfaceContainerLow = Color(0xFF0E0E0E),
        surfaceContainer = Color(0xFF151515),
        surfaceContainerHigh = Color(0xFF1D1D1D),
        surfaceContainerHighest = Color(0xFF282828),
        onSurfaceVariant = Color(0xFFCACACA),
        outline = Color(0xFF777777),
        outlineVariant = Color(0xFF414141),
        scrim = Color(0xFF000000),
        inverseSurface = Color(0xFFE8E8E8),
        inverseOnSurface = Color(0xFF2A2A2A),
        inversePrimary = Color(0xFF605A29),
    )
}