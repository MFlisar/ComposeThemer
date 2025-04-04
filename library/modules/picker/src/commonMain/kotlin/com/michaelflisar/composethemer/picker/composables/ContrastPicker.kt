package com.michaelflisar.composethemer.picker.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun ContrastPicker(
    state: ThemePicker.State,
    isSystemContrastSupported: Boolean,
    modifier: Modifier = Modifier,
    labelProvider: @Composable (item: ComposeTheme.Contrast) -> String? = { it.name },
    iconProvider: ((item: ComposeTheme.Contrast) -> ImageVector?)? = null,
) {
    ContrastPicker(
        state = state,
        isSystemContrastSupported = isSystemContrastSupported,
        modifier = modifier,
        label = {
            labelProvider(it)?.let {
                Text(it)
            }
        },
        icon = {
            iconProvider?.invoke(it)?.let {
                Icon(it, null)
            }
        }
    )
}

@Composable
fun ContrastPicker(
    state: ThemePicker.State,
    isSystemContrastSupported: Boolean,
    modifier: Modifier = Modifier,
    label: @Composable (item: ComposeTheme.Contrast) -> Unit = {},
    icon: @Composable (item: ComposeTheme.Contrast) -> Unit = {},
) {
    SingleChoice(
        modifier = modifier,
        items = listOfNotNull(
            ComposeTheme.Contrast.Normal,
            ComposeTheme.Contrast.Medium,
            ComposeTheme.Contrast.High,
            ComposeTheme.Contrast.System.takeIf { isSystemContrastSupported }
        ),
        selected = state.contrast,
        labelProvider = label,
        iconProvider = icon,
        enabled = state.isContrastEnabled()
    )
}