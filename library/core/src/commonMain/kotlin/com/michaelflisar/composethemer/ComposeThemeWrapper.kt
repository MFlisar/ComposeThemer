package com.michaelflisar.composethemer

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalComposeThemeState = compositionLocalOf<ComposeTheme.State> { throw RuntimeException("LocalComposeThemeState not initialised!") }

@Composable
internal fun ComposeThemeWrapper(
    state: ComposeTheme.State,
    colorScheme: ColorScheme,
    shapes: Shapes,
    typography: Typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalComposeThemeState provides state
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = shapes,
            typography = typography,
            content = content
        )
    }
}