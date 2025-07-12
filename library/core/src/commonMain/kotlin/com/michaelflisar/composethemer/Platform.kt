package com.michaelflisar.composethemer

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable

@Composable
expect fun ComposeTheme(
    state: ComposeTheme.State,
    shapes: Shapes = MaterialTheme.shapes,
    typography: Typography = MaterialTheme.typography,
    content: @Composable () -> Unit
)

// only on android 31+
expect val ComposeTheme.isDynamicColorsSupported : Boolean

// only on android 34+
expect val ComposeTheme.isContrastAvailable : Boolean
expect val ComposeTheme.isSystemContrastSupported : Boolean
