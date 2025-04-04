package com.michaelflisar.composethemer.picker.internal.spinners

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.PreviewColorScheme
import com.michaelflisar.composethemer.picker.internal.Spinner
import com.michaelflisar.composethemer.picker.internal.SpinnerText

@Composable
internal fun GroupSpinner(
    modifier: Modifier,
    groups: List<ComposeTheme.Group>,
    selectedGroup: MutableState<ComposeTheme.Group?>,
    setup: ThemePicker.SpinnerSetup<ComposeTheme.Group>,
    enabled: Boolean,
    isDark: Boolean,
    showVariantPicker: Boolean
) {
    Spinner(
        items = groups,
        selected = selectedGroup.value,
        onSelect = {
            selectedGroup.value = it
        },
        setup = setup,
        modifier = modifier,
        enabled = enabled
    ) { item, dropdown, modifier ->
        val colorScheme = item?.themes?.find { it.variantId() == item.collection.defaultVariantId }
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PreviewColorScheme(
                colorScheme = colorScheme?.getScheme(isDark, ComposeTheme.BaseContrast.Normal),
                preview = if (showVariantPicker) PreviewColorScheme.Preview.Primary else PreviewColorScheme.Preview.All
            )
            SpinnerText(
                modifier = Modifier.weight(1f),
                text = item?.name ?: "",
                selected = item == selectedGroup.value,
                dropdown = dropdown
            )
        }
    }
}