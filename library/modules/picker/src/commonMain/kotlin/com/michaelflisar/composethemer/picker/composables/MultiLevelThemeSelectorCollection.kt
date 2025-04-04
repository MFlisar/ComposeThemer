package com.michaelflisar.composethemer.picker.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.spinners.CollectionSpinner

@Composable
fun MultiLevelThemeSelectorCollection(
    state: ThemePicker.State,
    multiState: ThemePicker.MultiLevelState,
    modifier: Modifier = Modifier,
    spinnerSetup: ThemePicker.SpinnerSetup<ComposeTheme.Collection> = ThemePicker.SpinnerSetup.Default()
) {
    if (multiState.showCollectionPicker) {
        CollectionSpinner(
            modifier = modifier,
            collections = multiState.collections,
            selectedCollection = multiState.selectedCollection,
            setup = spinnerSetup,
            enabled = state.isThemeEnabled.value
        )
    }
}