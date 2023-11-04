package com.michaelflisar.composecustomthemes.defaultthemes

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.composables.materialcolors.ColorPalette
import com.composables.materialcolors.get

/**
 * Utility class to create m2 like m3 themes
 *
 * we map m3 colors labeled as from 10 - 100 in steps of 10 like following:
 * 10 => 100
 * 20 => 200
 * ...
 * 80 => 900
 * 100 => depending on the luminence we map it to white or black
 */
object MaterialThemeUtil {

    fun colorScheme(
        dark: Boolean,
        primary: ColorPalette,
        secondary: ColorPalette,
        tertiary: ColorPalette
    ): ColorScheme {
        return if (dark) darkColorScheme(
            primary,
            secondary,
            tertiary
        ) else lightColorScheme(primary, secondary, tertiary)
    }

    /** tint variation numbers copied from the default violet theme
     *
     * [androidx.compose.material3.tokens.ColorLightTokens]
     *
     */
    fun lightColorScheme(
        primary: ColorPalette,
        secondary: ColorPalette,
        tertiary: ColorPalette
    ): ColorScheme {
        val primary100 = if (primary[400].luminance() < .5f) Color.White else Color.Black
        val secondary100 = if (secondary[400].luminance() < .5f) Color.White else Color.Black
        val tertiary100 = if (tertiary[400].luminance() < .5f) Color.White else Color.Black
        return lightColorScheme(
            // PRIMARY
            primary = primary[400],                 // primary 40
            onPrimary = primary100,                 // primary 100
            primaryContainer = primary[900],        // primary 90
            onPrimaryContainer = primary[100],      // primary 10
            inversePrimary = primary[800],          // primary 80
            // SECONDARY
            secondary = secondary[400],             // seconary 40
            onSecondary = secondary100,             // seconary 100
            secondaryContainer = secondary[900],    // seconary 90
            onSecondaryContainer = secondary[100],  // seconary 10
            // TERTIARY
            tertiary = tertiary[400],               // tertiary 40
            onTertiary = tertiary100,               // tertiary 100
            tertiaryContainer = tertiary[900],      // tertiary 90
            onTertiaryContainer = tertiary[100],    // tertiary 10
            // REST
            // background = ColorLightTokens.Background,
            // onBackground = ColorLightTokens.OnBackground,
            // surface = ColorLightTokens.Surface,
            // onSurface = ColorLightTokens.OnSurface,
            // surfaceVariant = ColorLightTokens.SurfaceVariant,
            // onSurfaceVariant = ColorLightTokens.OnSurfaceVariant,
            surfaceTint = primary[400],             // primary
            //inverseSurface = ColorLightTokens.InverseSurface,
            //inverseOnSurface = ColorLightTokens.InverseOnSurface,
            //error = ColorLightTokens.Error,
            //onError = ColorLightTokens.OnError,
            //errorContainer = ColorLightTokens.ErrorContainer,
            //onErrorContainer = ColorLightTokens.OnErrorContainer,
            //outline = ColorLightTokens.Outline,
            //outlineVariant = ColorLightTokens.OutlineVariant,
            //scrim = ColorLightTokens.Scrim
        )
    }


    /** tint variation numbers simple copied from the default violet theme
     *
     * [androidx.compose.material3.tokens.ColorLightTokens]
     *
     */
    fun darkColorScheme(
        primary: ColorPalette,
        secondary: ColorPalette,
        tertiary: ColorPalette
    ): ColorScheme {
        return darkColorScheme(
            // PRIMARY
            primary = primary[800],                  // primary 80
            onPrimary = primary[200],                // primary 20
            primaryContainer = primary[300],         // primary 30
            onPrimaryContainer = primary[900],       // primary 90
            inversePrimary = primary[400],           // primary 40
            // SECONDARY
            secondary = secondary[800],              // seconary 80
            onSecondary = secondary[200],            // seconary 20
            secondaryContainer = secondary[300],     // seconary 30
            onSecondaryContainer = secondary[900],   // seconary 90
            // TERTIARY
            tertiary = tertiary[800],                // tertiary 80
            onTertiary = tertiary[200],              // tertiary 20
            tertiaryContainer = tertiary[300],       // tertiary 30
            onTertiaryContainer = tertiary[900],     // tertiary 90
            // REST
            //background = ColorDarkTokens.Background,
            //onBackground = ColorDarkTokens.OnBackground,
            //surface = ColorDarkTokens.Surface,
            //onSurface = ColorDarkTokens.OnSurface,
            //surfaceVariant = ColorDarkTokens.SurfaceVariant,
            //onSurfaceVariant = ColorDarkTokens.OnSurfaceVariant,
            surfaceTint = primary[800],              // primary
            //inverseSurface = ColorDarkTokens.InverseSurface,
            //inverseOnSurface = ColorDarkTokens.InverseOnSurface,
            //error = ColorDarkTokens.Error,
            //onError = ColorDarkTokens.OnError,
            //errorContainer = ColorDarkTokens.ErrorContainer,
            //onErrorContainer = ColorDarkTokens.OnErrorContainer,
            //outline = ColorDarkTokens.Outline,
            //outlineVariant = ColorDarkTokens.OutlineVariant,
            //scrim = ColorDarkTokens.Scrim,
        )
    }
}