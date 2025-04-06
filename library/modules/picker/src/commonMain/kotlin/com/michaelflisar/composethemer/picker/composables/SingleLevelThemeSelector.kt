package com.michaelflisar.composethemer.picker.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.internal.SingleChoice

@Composable
fun SingleLevelThemeSelector(
    state: ThemePicker.State,
    modifier: Modifier = Modifier,
    style: SingleChoice.Style<ComposeTheme.Theme> = SingleChoice.Style.Dropdown(
        SingleChoice.SpinnerSetup.Default()
    ),
) {
    val selected = remember(
        state.selectedThemeId.value,
        state.allThemes
    ) { derivedStateOf { state.allThemes.find { it.id == state.selectedThemeId.value } } }

    SingleChoice(
        modifier = modifier,
        items = state.allThemes,
        selected = selected.value,
        onSelect = {
            state.selectedThemeId.value = it.id
        },
        style = style,
        enabled = state.isThemeEnabled.value,
    ) { item, data ->
        val colorScheme =
            item?.getScheme(state.baseTheme.value.isDark(), ComposeTheme.BaseContrast.Normal)
        Row(
            modifier = data.modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ThemeColorPreview(
                colorScheme = colorScheme,
                preview = ThemeColorPreview.Type.All
            )
            Text(
                text = item?.fullName ?: "",
                color = data.textColor(),
                maxLines = 1
            )
        }
    }
}