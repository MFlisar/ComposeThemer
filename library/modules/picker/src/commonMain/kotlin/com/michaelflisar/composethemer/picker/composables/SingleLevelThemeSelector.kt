package com.michaelflisar.composethemer.picker.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.spinners.ThemeSpinner

@Composable
fun SingleLevelThemeSelector(
    state: ThemePicker.State,
    modifier: Modifier = Modifier,
    spinnerSetup: ThemePicker.SpinnerSetup<ComposeTheme.Theme> = ThemePicker.SpinnerSetup.Default()
) {
    ThemeSpinner(
        modifier = modifier,
        themes = state.allThemes,
        selectedThemeId = state.selectedThemeId,
        setup = spinnerSetup,
        enabled = state.isThemeEnabled.value,
        isDark = state.baseTheme.value.isDark()
    )
}