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
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun MultiLevelThemeSelectorTheme(
    state: ThemePicker.State,
    multiState: ThemePicker.MultiLevelState,
    modifier: Modifier = Modifier,
    style: SingleChoice.Style<ComposeTheme.Group> = SingleChoice.Style.Dropdown(
        SingleChoice.SpinnerSetup.Default()
    )
) {
    SingleChoice(
        modifier = modifier,
        items = multiState.groups,
        selected = multiState.selectedGroup.value,
        onSelect = { multiState.selectedGroup.value = it },
        style = style,
        enabled = state.isThemeEnabled.value,
    ) { item, data ->
        val colorScheme = item?.themes?.find { it.variantId() == item.collection.defaultVariantId }
        Row(
            modifier = data.modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ThemeColorPreview(
                colorScheme = colorScheme?.getScheme(
                    state.baseTheme.value.isDark(),
                    ComposeTheme.BaseContrast.Normal
                ),
                preview = if (multiState.showVariantPicker) ThemeColorPreview.Type.Primary else ThemeColorPreview.Type.All
            )
            Text(
                text = item?.name ?: "",
                color = data.textColor(),
                maxLines = 1
            )
        }
    }
}