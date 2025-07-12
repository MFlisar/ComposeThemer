package com.michaelflisar.composethemer.picker.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.isSystemContrastSupported
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun ContrastPicker(
    state: ThemePicker.State,
    modifier: Modifier = Modifier,
    style: SingleChoice.Style<ComposeTheme.Contrast> = SingleChoice.Style.SegmentedButton(),
    content: @Composable (item: ComposeTheme.Contrast?, data: SingleChoice.ItemData) -> Unit,
) {
    SingleChoice(
        modifier = modifier,
        items = listOfNotNull(
            ComposeTheme.Contrast.Normal,
            ComposeTheme.Contrast.Medium,
            ComposeTheme.Contrast.High,
            ComposeTheme.Contrast.System.takeIf { ComposeTheme.isSystemContrastSupported }
        ),
        selected = state.contrast.value,
        onSelect = { state.contrast.value = it },
        style = style,
        content = content,
        enabled = state.isContrastEnabled.value
    )
}