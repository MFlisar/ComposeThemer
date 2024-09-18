package com.michaelflisar.composethemer

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
fun ComposeTheme(
    state: ComposeTheme.State,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
) {
    val theme = ComposeTheme.find(state.theme.value)
    val colorScheme = when {
        state.base.value.isDark() -> theme.colorSchemeDark
        else -> theme.colorSchemeLight
    }
    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content
    )
}