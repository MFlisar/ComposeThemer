package com.michaelflisar.composethemer.picker.internal.spinners

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.PreviewColorScheme
import com.michaelflisar.composethemer.picker.internal.Spinner
import com.michaelflisar.composethemer.picker.internal.SpinnerText

@Composable
internal fun ThemeSpinner(
    modifier: Modifier,
    themes: List<ComposeTheme.Theme>,
    selectedThemeId: MutableState<String>,
    setup: ThemePicker.SpinnerSetup<ComposeTheme.Theme>,
    enabled: Boolean,
    isDark: Boolean
) {
    val selected = remember(
        selectedThemeId.value,
        themes
    ) { derivedStateOf { themes.find { it.id == selectedThemeId.value } } }
    Spinner(
        items = themes,
        selected = selected.value,
        onSelect = {
            selectedThemeId.value = it.id
        },
        setup = setup,
        modifier = modifier,
        enabled = enabled
    ) { item, dropdown, modifier ->
        val colorScheme = item?.getScheme(isDark, ComposeTheme.BaseContrast.Normal)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PreviewColorScheme(
                colorScheme = colorScheme,
                preview = PreviewColorScheme.Preview.All
            )
            SpinnerText(
                modifier = Modifier.weight(1f),
                text = item?.fullName ?: "",
                selected = item == selected.value,
                dropdown = dropdown
            )
        }
    }
}