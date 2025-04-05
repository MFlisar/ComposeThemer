package com.michaelflisar.composethemer.picker.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.classes.Variant
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun MultiLevelThemeSelectorVariant(
    state: ThemePicker.State,
    multiState: ThemePicker.MultiLevelState,
    modifier: Modifier = Modifier,
    style: SingleChoice.Style<Variant> = SingleChoice.Style.Dropdown(
        SingleChoice.SpinnerSetup.Default()
    )
) {
    if (multiState.showVariantPicker) {
        SingleChoice(
            modifier = modifier,
            items = multiState.variants,
            selected = multiState.selectedVariant.value,
            onSelect = { multiState.selectedVariant.value = it },
            style = style,
            enabled = state.isThemeEnabled.value,
        ) { item, data ->
            val theme = multiState.themesOfSelectedGroup.find { it.variantId() == item?.id }
            val colorScheme =
                theme?.getScheme(state.baseTheme.value.isDark(), ComposeTheme.BaseContrast.Normal)
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ThemeColorPreview(
                    colorScheme = colorScheme,
                    preview = ThemeColorPreview.Type.All
                )
                Text(
                    text = item?.name ?: "",
                    color = data.textColor(),
                    maxLines = 1
                )
            }
        }
    }
}