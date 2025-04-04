package com.michaelflisar.composethemer.picker.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.classes.Variant
import com.michaelflisar.composethemer.picker.internal.spinners.CollectionSpinner
import com.michaelflisar.composethemer.picker.internal.spinners.VariantSpinner

@Composable
fun MultiLevelThemeSelectorVariant(
    state: ThemePicker.State,
    multiState: ThemePicker.MultiLevelState,
    modifier: Modifier = Modifier,
    spinnerSetup: ThemePicker.SpinnerSetup<Variant> = ThemePicker.SpinnerSetup.Default()
) {
    if (multiState.showVariantPicker) {
        VariantSpinner(
            modifier = modifier,
            variants = multiState.variants,
            selectedVariant = multiState.selectedVariant,
            themesOfGroup = multiState.themesOfSelectedGroup,
            setup = spinnerSetup,
            enabled = state.isThemeEnabled.value,
            isDark = state.baseTheme.value.isDark()
        )
    }
}