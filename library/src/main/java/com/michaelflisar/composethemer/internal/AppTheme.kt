package com.michaelflisar.composethemer.internal

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import com.michaelflisar.composethemer.ComposeThemePrefs
import com.michaelflisar.composethemer.collectAsState

internal class AppTheme(
    // Main Colors
    val primary: State<Int>,
    val onPrimary: State<Int>,
    val secondary: State<Int>,
    val onSecondary: State<Int>,
    val tertiary: State<Int>,
    val onTertiary: State<Int>,
    // Container
    val primaryContainer: State<Int>,
    val onPrimaryContainer: State<Int>,
    val secondaryContainer: State<Int>,
    val onSecondaryContainer: State<Int>,
    val tertiaryContainer: State<Int>,
    val onTertiaryContainer: State<Int>,
    // Background/Surface
    val background: State<Int>,
    val onBackground: State<Int>,
    val surface: State<Int>,
    val onSurface: State<Int>,
    val surfaceVariant: State<Int>,
    val onSurfaceVariant: State<Int>,
    val surfaceTint: State<Int>,
    // Inverse
    val inversePrimary: State<Int>,
    val inverseSurface: State<Int>,
    val inverseOnSurface: State<Int>,
    // Specials
    val error: State<Int>,
    val onError: State<Int>,
    val errorContainer: State<Int>,
    val onErrorContainer: State<Int>,
    val outline: State<Int>,
    val outlineVariant: State<Int>,
    val scrim: State<Int>
) {
    companion object {
        @Composable
        fun create(prefs: ComposeThemePrefs) : AppTheme {
            return AppTheme(
                // Main Colors
                primary = prefs.primary.collectAsState(),
                onPrimary = prefs.onPrimary.collectAsState(),
                secondary = prefs.secondary.collectAsState(),
                onSecondary = prefs.onSecondary.collectAsState(),
                tertiary = prefs.tertiary.collectAsState(),
                onTertiary = prefs.onTertiary.collectAsState(),
                // Container
                primaryContainer = prefs.primaryContainer.collectAsState(),
                onPrimaryContainer = prefs.onPrimaryContainer.collectAsState(),
                secondaryContainer = prefs.secondaryContainer.collectAsState(),
                onSecondaryContainer = prefs.onSecondaryContainer.collectAsState(),
                tertiaryContainer = prefs.tertiaryContainer.collectAsState(),
                onTertiaryContainer = prefs.onTertiaryContainer.collectAsState(),
                // Background/Surface
                background = prefs.background.collectAsState(),
                onBackground = prefs.onBackground.collectAsState(),
                surface = prefs.surface.collectAsState(),
                onSurface = prefs.onSurface.collectAsState(),
                surfaceVariant = prefs.surfaceVariant.collectAsState(),
                onSurfaceVariant = prefs.onSurfaceVariant.collectAsState(),
                surfaceTint = prefs.surfaceTint.collectAsState(),
                // Inverse
                inversePrimary = prefs.inversePrimary.collectAsState(),
                inverseSurface = prefs.inverseSurface.collectAsState(),
                inverseOnSurface = prefs.inverseOnSurface.collectAsState(),
                // Specials
                error = prefs.error.collectAsState(),
                onError = prefs.onError.collectAsState(),
                errorContainer = prefs.errorContainer.collectAsState(),
                onErrorContainer = prefs.onErrorContainer.collectAsState(),
                outline = prefs.outline.collectAsState(),
                outlineVariant = prefs.outlineVariant.collectAsState(),
                scrim = prefs.scrim.collectAsState()
            )
        }
    }

    fun getAsDarkTheme() = darkColorScheme(
        // Main Colors
        primary = Color(primary.value),
        onPrimary = Color(onPrimary.value),
        secondary = Color(secondary.value),
        onSecondary = Color(onSecondary.value),
        tertiary = Color(tertiary.value),
        onTertiary = Color(onTertiary.value),
        // Container
        primaryContainer = Color(primaryContainer.value),
        onPrimaryContainer = Color(onPrimaryContainer.value),
        secondaryContainer = Color(secondaryContainer.value),
        onSecondaryContainer = Color(onSecondaryContainer.value),
        tertiaryContainer = Color(tertiaryContainer.value),
        onTertiaryContainer = Color(onTertiaryContainer.value),
        // Background/Surface
        background = Color(background.value),
        onBackground = Color(onBackground.value),
        surface = Color(surface.value),
        onSurface = Color(onSurface.value),
        surfaceVariant = Color(surfaceVariant.value),
        onSurfaceVariant = Color(onSurfaceVariant.value),
        surfaceTint = Color(surfaceTint.value),
        // Inverse
        inversePrimary = Color(inversePrimary.value),
        inverseSurface = Color(inverseSurface.value),
        inverseOnSurface = Color(inverseOnSurface.value),
        // Specials
        error = Color(error.value),
        onError = Color(onError.value),
        errorContainer = Color(errorContainer.value),
        onErrorContainer = Color(onErrorContainer.value),
        outline = Color(outline.value),
        outlineVariant = Color(outlineVariant.value),
        scrim = Color(scrim.value)
    )

    fun getAsLightTheme() = lightColorScheme(
        // Main Colors
        primary = Color(primary.value),
        onPrimary = Color(onPrimary.value),
        secondary = Color(secondary.value),
        onSecondary = Color(onSecondary.value),
        tertiary = Color(tertiary.value),
        onTertiary = Color(onTertiary.value),
        // Container
        primaryContainer = Color(primaryContainer.value),
        onPrimaryContainer = Color(onPrimaryContainer.value),
        secondaryContainer = Color(secondaryContainer.value),
        onSecondaryContainer = Color(onSecondaryContainer.value),
        tertiaryContainer = Color(tertiaryContainer.value),
        onTertiaryContainer = Color(onTertiaryContainer.value),
        // Background/Surface
        background = Color(background.value),
        onBackground = Color(onBackground.value),
        surface = Color(surface.value),
        onSurface = Color(onSurface.value),
        surfaceVariant = Color(surfaceVariant.value),
        onSurfaceVariant = Color(onSurfaceVariant.value),
        surfaceTint = Color(surfaceTint.value),
        // Inverse
        inversePrimary = Color(inversePrimary.value),
        inverseSurface = Color(inverseSurface.value),
        inverseOnSurface = Color(inverseOnSurface.value),
        // Specials
        error = Color(error.value),
        onError = Color(onError.value),
        errorContainer = Color(errorContainer.value),
        onErrorContainer = Color(onErrorContainer.value),
        outline = Color(outline.value),
        outlineVariant = Color(outlineVariant.value),
        scrim = Color(scrim.value)
    )
}