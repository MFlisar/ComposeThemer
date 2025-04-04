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
fun BaseThemePicker(
    state: ThemePicker.State,
    modifier: Modifier = Modifier,
    labelProvider: (item: ComposeTheme.BaseTheme) -> String? = { it.name },
    iconProvider: ((item: ComposeTheme.BaseTheme) -> ImageVector?)? = null
) {
    BaseThemePicker(
        state = state,
        modifier = modifier,
        label = {
            val text by remember { derivedStateOf { labelProvider(it) } }
            text?.let {
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
fun BaseThemePicker(
    state: ThemePicker.State,
    modifier: Modifier = Modifier,
    label: @Composable (item: ComposeTheme.BaseTheme) -> Unit = {},
    icon: @Composable (item: ComposeTheme.BaseTheme) -> Unit = {}
) {
    SingleChoice(
        modifier = modifier,
        items = listOf(
            ComposeTheme.BaseTheme.Light,
            ComposeTheme.BaseTheme.Dark,
            ComposeTheme.BaseTheme.System
        ),
        selected = state.baseTheme,
        labelProvider = label,
        iconProvider = icon,
        enabled = true
    )
}