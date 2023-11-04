package com.michaelflisar.composecustomthemes.defaultthemes

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import com.composables.materialcolors.ColorPalette
import com.composables.materialcolors.get
import com.michaelflisar.composecustomthemes.defaultthemes.MaterialThemeUtil.darken

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

        // HACK SOLUTION:
        // to get rid of the violet tint from the default theme and because of a lack of understanding on how the colors are calculated
        // I simply use gray colors for the surface and surface variant values!
        // => I simply copied the default values from the violet theme and set all values to the same => this creates gray shades
        val surfaceVariant = Color(red = 231, green = 231, blue = 231)
        val onSurfaceVariant = Color(red = 73, green = 73, blue = 73)
        val outline = Color(red = 121, green = 121, blue = 121)
        val outlineVariant = Color(red = 202, green = 202, blue = 202)
        val inverseSurface = Color(red = 49, green = 49, blue = 49)
        val inverseOnSurface = Color(red = 244, green = 244, blue = 244)

        return lightColorScheme(
            // PRIMARY
            primary = primary[400],                     // primary 40
            onPrimary = primary100,                     // primary 100
            primaryContainer = primary[900],            // primary 90
            onPrimaryContainer = primary[100],          // primary 10
            inversePrimary = primary[800],              // primary 80
            // SECONDARY
            secondary = secondary[400],                 // seconary 40
            onSecondary = secondary100,                 // seconary 100
            secondaryContainer = secondary[900],        // seconary 90
            onSecondaryContainer = secondary[100],      // seconary 10
            // TERTIARY
            tertiary = tertiary[400],                   // tertiary 40
            onTertiary = tertiary100,                   // tertiary 100
            tertiaryContainer = tertiary[900],          // tertiary 90
            onTertiaryContainer = tertiary[100],        // tertiary 10
            // BACKGROUND/SURFACE => we keep the defaults
            // background = ,           // neutral 99
            // onBackground = ,         // neutral 10
            // surface = ,              // neutral 99
            // onSurface = ,            // neutral 10
            // VARIANTS
            surfaceVariant = surfaceVariant,            // neutral variant 90
            onSurfaceVariant = onSurfaceVariant,        // neutral variant 30
            surfaceTint = primary[400],                 // primary
            inverseSurface = inverseSurface,            // neutral 20
            inverseOnSurface = inverseOnSurface,        // neutral 95
            // ERROR => we keep the defaults
            //error = ,                 // error 40
            //onError = ,               // error 100
            //errorContainer = ,        // error 90
            //onErrorContainer = ,      // error 10
            // OUTLINE
            outline = outline,                          // neutral variant 50
            outlineVariant = outlineVariant,            // neutral variant 80
            //scrim =                   // neutral 0
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

        // HACK SOLUTION:
        // to get rid of the violet tint from the default theme and because of a lack of understanding on how the colors are calculated
        // I simply use gray colors for the surface and surface variant values!
        // => I simply copied the default values from the violet theme and set all values to the same => this creates gray shades
        val surfaceVariant = Color(red = 73, green = 73, blue = 73)
        val onSurfaceVariant = Color(red = 202, green = 202, blue = 202)
        val outline = Color(red = 147, green = 147, blue = 147)
        val outlineVariant = Color(red = 73, green = 73, blue = 73)
        val inverseSurface = Color(red = 229, green = 229, blue = 229)
        val inverseOnSurface = Color(red = 49, green = 49, blue = 49)

        return darkColorScheme(
            // PRIMARY
            primary = primary[800],                     // primary 80
            onPrimary = primary[200],                   // primary 20
            primaryContainer = primary[300],            // primary 30
            onPrimaryContainer = primary[900],          // primary 90
            inversePrimary = primary[400],              // primary 40
            // SECONDARY
            secondary = secondary[800],                 // seconary 80
            onSecondary = secondary[200],               // seconary 20
            secondaryContainer = secondary[300],        // seconary 30
            onSecondaryContainer = secondary[900],      // seconary 90
            // TERTIARY
            tertiary = tertiary[800],                   // tertiary 80
            onTertiary = tertiary[200],                 // tertiary 20
            tertiaryContainer = tertiary[300],          // tertiary 30
            onTertiaryContainer = tertiary[900],        // tertiary 90
            // BACKGROUND/SURFACE => we keep the defaults
            // background = ,           // neutral 10
            // onBackground = ,         // neutral 90
            // surface = ,              // neutral 10
            // onSurface = ,            // neutral 90
            // VARIANTS
            surfaceVariant = surfaceVariant,            // neutral variant 30
            onSurfaceVariant = onSurfaceVariant,        // neutral variant 80
            surfaceTint = primary[800],                 // primary
            inverseSurface = inverseSurface,            // neutral 90
            inverseOnSurface = inverseOnSurface,        // neutral 20
            // ERROR => we keep the defaults
            //error = ,                 // error 80
            //onError = ,               // error 20
            //errorContainer = ,        // error 30
            //onErrorContainer = ,      // error 90
            // OUTLINE
            outline = outline,                          // neutral variant 60
            outlineVariant = outlineVariant,            // neutral variant 30
            //scrim =                   // neutral 0
        )
    }

    private fun Color.darken(): Color {
        val c = this.toArgb()
        val adjusted = android.graphics.Color.HSVToColor(FloatArray(3).apply {
            android.graphics.Color.colorToHSV(c, this)
            this[2] *= 0.8f
        })
        return Color(adjusted)
    }

    private fun Color.lighten(): Color {
        val c = this.toArgb()
        val adjusted = android.graphics.Color.HSVToColor(FloatArray(3).apply {
            android.graphics.Color.colorToHSV(c, this)
            this[2] *= 1.2f
        })
        return Color(adjusted)
    }
}