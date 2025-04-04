package com.michaelflisar.composethemer.picker.internal.spinners

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.Spinner
import com.michaelflisar.composethemer.picker.internal.SpinnerText

@Composable
internal fun CollectionSpinner(
    modifier: Modifier,
    collections: List<ComposeTheme.Collection>,
    selectedCollection: MutableState<ComposeTheme.Collection?>,
    setup: ThemePicker.SpinnerSetup<ComposeTheme.Collection>,
    enabled: Boolean
) {
    Spinner(
        items = collections,
        selected = selectedCollection.value,
        onSelect = {
            selectedCollection.value = it
        },
        setup = setup,
        modifier = modifier,
        enabled = enabled
    ) { item, dropdown, modifier ->
        SpinnerText(
            modifier = modifier,
            text = item?.name ?: "",
            selected = item == selectedCollection.value,
            dropdown = dropdown
        )
    }
}