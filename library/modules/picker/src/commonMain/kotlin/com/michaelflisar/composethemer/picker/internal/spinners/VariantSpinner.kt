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
import com.michaelflisar.composethemer.picker.classes.Variant
import com.michaelflisar.composethemer.picker.composables.ThemeColorPreview
import com.michaelflisar.composethemer.picker.internal.Spinner
import com.michaelflisar.composethemer.picker.internal.SpinnerText

@Composable
internal fun VariantSpinner(
    modifier: Modifier,
    variants: List<Variant>,
    themesOfGroup: List<ComposeTheme.Theme>,
    selectedVariant: MutableState<Variant?>,
    setup: ThemePicker.SpinnerSetup<Variant>,
    enabled: Boolean,
    isDark: Boolean
) {
    Spinner(
        items = variants,
        selected = selectedVariant.value,
        onSelect = {
            selectedVariant.value = it
        },
        setup = setup,
        modifier = modifier,
        enabled = enabled
    ) { item, dropdown, modifier ->
        val theme = themesOfGroup.find { it.variantId() == item?.id }
        val colorScheme = theme?.getScheme(isDark, ComposeTheme.BaseContrast.Normal)
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ThemeColorPreview(
                colorScheme = colorScheme,
                preview = ThemeColorPreview.Type.All
            )
            SpinnerText(
                modifier = Modifier.weight(1f),
                text = item?.name ?: "",
                selected = item == selectedVariant.value,
                dropdown =  dropdown
            )
        }
    }
}