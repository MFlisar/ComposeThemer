package com.michaelflisar.composethemer

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

/**
 * this is the main composable that simple applies the correct theme
 * and also updates the system ui if necessary
 *
 * @param state the composable state that holds the currently selected theme data
 * @param shapes the shapes for [MaterialTheme]
 * @param typography the typography for [MaterialTheme]
 * @param content the content
 */
@Composable
actual fun ComposeTheme(
    state: ComposeTheme.State,
    shapes: Shapes,
    typography: Typography,
    content: @Composable () -> Unit
) {
    val theme = ComposeTheme.find(state.theme.value)
    val colorScheme = theme.selectSchemeForContrast(state.base.value.isDark(), state.contrast.value)
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}

@Composable
fun ComposeTheme.Theme.selectSchemeForContrast(isDark: Boolean, contrast: ComposeTheme.Contrast): ColorScheme {
    val baseContrast = when (contrast) {
        ComposeTheme.Contrast.System -> ComposeTheme.BaseContrast.Normal
        ComposeTheme.Contrast.Normal -> ComposeTheme.BaseContrast.Normal
        ComposeTheme.Contrast.Medium ->ComposeTheme.BaseContrast.Medium
        ComposeTheme.Contrast.High -> ComposeTheme.BaseContrast.High
    }
    return getScheme(isDark, baseContrast)
}