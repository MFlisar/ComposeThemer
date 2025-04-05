package com.michaelflisar.composethemer.picker.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun BaseThemePicker(
    state: ThemePicker.State,
    modifier: Modifier = Modifier,
    style: SingleChoice.Style<ComposeTheme.BaseTheme> = SingleChoice.Style.SegmentedButton(),
    content: @Composable (item: ComposeTheme.BaseTheme?, data: SingleChoice.ItemData) -> Unit,
) {
    SingleChoice(
        modifier = modifier,
        items = listOf(
            ComposeTheme.BaseTheme.Light,
            ComposeTheme.BaseTheme.Dark,
            ComposeTheme.BaseTheme.System
        ),
        selected = state.baseTheme.value,
        onSelect = {
            state.baseTheme.value = it
        },
        style = style,
        content = content
    )
}