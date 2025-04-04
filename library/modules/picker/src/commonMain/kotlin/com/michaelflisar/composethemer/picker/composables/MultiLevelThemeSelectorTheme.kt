package com.michaelflisar.composethemer.picker.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.spinners.CollectionSpinner
import com.michaelflisar.composethemer.picker.internal.spinners.GroupSpinner

@Composable
fun MultiLevelThemeSelectorTheme(
    state: ThemePicker.State,
    multiState: ThemePicker.MultiLevelState,
    modifier: Modifier = Modifier,
    spinnerSetup: ThemePicker.SpinnerSetup<ComposeTheme.Group> = ThemePicker.SpinnerSetup.Default()
) {
    GroupSpinner(
        modifier = modifier,
        groups = multiState.groups,
        selectedGroup = multiState.selectedGroup,
        setup = spinnerSetup,
        enabled = state.isThemeEnabled(),
        isDark = state.baseTheme.value.isDark(),
        showVariantPicker = multiState.showVariantPicker
    )
}