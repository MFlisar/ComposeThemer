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
 * FlexColor Theme Name: "Oh Mandy Red"
 */
object ThemeOhMandyRed {

    const val KEY = "Oh Mandy Red"

    fun get() = ComposeTheme.Theme(
        key = KEY,
        colorSchemeLight = Light,
        colorSchemeDark = Dark
    )

    private val Light = lightColorScheme(
        primary = Color(0xFFCD5758),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFE49797),
        onPrimaryContainer = Color(0xFF000000),
        secondary = Color(0xFF57C8D3),
        onSecondary = Color(0xFF000000),
        secondaryContainer = Color(0xFF90F2FC),
        onSecondaryContainer = Color(0xFF000000),
        tertiary = Color(0xFF69B9CD),
        onTertiary = Color(0xFF000000),
        tertiaryContainer = Color(0xFFA6EDFF),
        onTertiaryContainer = Color(0xFF000000),
        error = Color(0xFF790000),
        onError = Color(0xFFFFFFFF),
        errorContainer = Color(0xFFF1D8D8),
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
        inversePrimary = Color(0xFFFFF0F0),
        surfaceTint = Color(0xFFCD5758), // copied from: primary
        surfaceVariant = Color(0xFFD1D1D1), // copied from: outlineVariant
        background = Color(0xFFFCFCFC), // copied from: surface
        onBackground = Color(0xFF111111), // copied from: onSurface
    )

    private val Dark = darkColorScheme(
        primary = Color(0xFFDA8585),
        onPrimary = Color(0xFFFFFFFF),
        primaryContainer = Color(0xFFC05253),
        onPrimaryContainer = Color(0xFFFFFFFF),
        secondary = Color(0xFF68CDD7),
        onSecondary = Color(0xFF000000),
        secondaryContainer = Color(0xFF037481),
        onSecondaryContainer = Color(0xFFFFFFFF),
        tertiary = Color(0xFF85C6D6),
        onTertiary = Color(0xFF000000),
        tertiaryContainer = Color(0xFF21859E),
        onTertiaryContainer = Color(0xFFFFFFFF),
        error = Color(0xFFCF6679),
        onError = Color(0xFF000000),
        errorContainer = Color(0xFFB1384E),
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
        inversePrimary = Color(0xFF613F3F),
        surfaceTint = Color(0xFFDA8585), // copied from: primary
        surfaceVariant = Color(0xFF414141), // copied from: outlineVariant
        background = Color(0xFF080808), // copied from: surface
        onBackground = Color(0xFFF1F1F1), // copied from: onSurface
    )
}