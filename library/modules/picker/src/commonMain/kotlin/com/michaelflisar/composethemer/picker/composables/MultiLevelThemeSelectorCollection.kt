package com.michaelflisar.composethemer.picker.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun MultiLevelThemeSelectorCollection(
    state: ThemePicker.State,
    multiState: ThemePicker.MultiLevelState,
    modifier: Modifier = Modifier,
    style: SingleChoice.Style<ComposeTheme.Collection> = SingleChoice.Style.Dropdown(
        SingleChoice.SpinnerSetup.Default()
    )
) {
    if (multiState.showCollectionPicker) {
        SingleChoice(
            modifier = modifier,
            items = multiState.collections,
            selected = multiState.selectedCollection.value,
            onSelect = { multiState.selectedCollection.value = it },
            style = style,
            enabled = state.isThemeEnabled.value
        ) { item, data ->
            Text(
                modifier = data.modifier,
                text = item?.name ?: "",
                color = data.textColor(),
                maxLines = 1
            )
        }
    }
}