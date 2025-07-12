package com.michaelflisar.composethemer.picker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.BrightnessLow
import androidx.compose.material.icons.filled.BrightnessMedium
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LaptopWindows
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.isContrastAvailable
import com.michaelflisar.composethemer.isDynamicColorsSupported
import com.michaelflisar.composethemer.picker.composables.BaseThemePicker
import com.michaelflisar.composethemer.picker.composables.ContrastPicker
import com.michaelflisar.composethemer.picker.composables.MultiLevelThemeSelectorCollection
import com.michaelflisar.composethemer.picker.composables.MultiLevelThemeSelectorTheme
import com.michaelflisar.composethemer.picker.composables.MultiLevelThemeSelectorVariant
import com.michaelflisar.composethemer.picker.composables.SingleLevelThemeSelector
import com.michaelflisar.composethemer.picker.composables.ThemePickerRow
import com.michaelflisar.composethemer.picker.internal.SingleChoice

/* --8<-- [start: constructor] */
@Composable
fun DefaultThemePicker(
    modifier: Modifier,
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    theme: MutableState<String>,
    singleLevelThemePicker: Boolean,
    labelWidth: Dp = 128.dp,
    labelBaseTheme: String = "Base Theme",
    labelContrast: String = "Contrast",
    labelDynamic: String = "Dynamic Colors",
    labelTheme: String = "Theme",
    filterLabel: String = "Filter",
    filterPlaceholder: String = "Search in themes",
    imageVectorSystem: ImageVector? = Icons.Default.LaptopWindows,
    baseThemeContent: @Composable (item: ComposeTheme.BaseTheme?, data: SingleChoice.ItemData) -> Unit = { item, data ->
        val icon = when (item) {
            ComposeTheme.BaseTheme.Dark -> Icons.Default.DarkMode
            ComposeTheme.BaseTheme.Light -> Icons.Default.LightMode
            ComposeTheme.BaseTheme.System -> imageVectorSystem
            else -> null
        }
        DefaultThemePickerIconTextContent(data, icon = icon, text = item?.name)
    },
    contrastContent: @Composable (item: ComposeTheme.Contrast?, data: SingleChoice.ItemData) -> Unit = { item, data ->
        val icon = when (item) {
            ComposeTheme.Contrast.Normal -> Icons.Default.BrightnessLow
            ComposeTheme.Contrast.Medium -> Icons.Default.BrightnessMedium
            ComposeTheme.Contrast.High -> Icons.Default.BrightnessHigh
            ComposeTheme.Contrast.System -> imageVectorSystem
            else -> null
        }
        DefaultThemePickerIconTextContent(data, icon = icon, text = item?.name)
    },
)
        /* --8<-- [end: constructor] */
{

    Column(
        modifier = modifier
    ) {

        // 0) create a state that handles the dependencies
        val pickerState = rememberThemePicker(
            baseTheme = baseTheme,
            contrast = contrast,
            dynamic = dynamic,
            themeId = theme
        )

        // 1) row to pick base theme (dark/light/system)
        ThemePickerRow(
            modifier = Modifier.fillMaxWidth(),
            label = labelBaseTheme,
            labelWidth = labelWidth
        ) {
            BaseThemePicker(
                modifier = Modifier.fillMaxWidth(),
                state = pickerState,
                content = baseThemeContent
            )
        }

        // 2) row to enabled / disable dynamic colors
        if (ComposeTheme.isDynamicColorsSupported) {
            ThemePickerRow(
                modifier = Modifier.fillMaxWidth(),
                label = labelDynamic,
                labelWidth = labelWidth
            ) {
                Switch(
                    checked = pickerState.dynamic.value,
                    onCheckedChange = {
                        pickerState.dynamic.value = it
                    }
                )
            }
        }

        // 3) row to pick contrast (normal/medium/high/system)
        // if this setting is currently enabled or not can be checked via the state
        if (ComposeTheme.isContrastAvailable) {
            ThemePickerRow(
                modifier = Modifier.fillMaxWidth(),
                label = labelContrast,
                labelWidth = labelWidth,
                enabled = pickerState.isContrastEnabled.value
            ) {
                ContrastPicker(
                    modifier = Modifier.fillMaxWidth(),
                    state = pickerState,
                    content = contrastContent
                )
            }
        }

        // 4) row to pick theme
        // this shows a 3 level based theme picker
        // => if all 3 levels are necessary to show is handled automatically by the state already
        ThemePickerRow(
            modifier = Modifier.fillMaxWidth(),
            label = labelTheme,
            labelWidth = labelWidth,
            enabled = pickerState.isThemeEnabled.value
        ) {
            // you have 2 options:
            // - a spinner with all themes
            // - a 3 level based theme picker (collection, theme, variant)
            if (singleLevelThemePicker) {
                SingleLevelThemeSelector(
                    state = pickerState,
                    modifier = Modifier.fillMaxWidth(),
                    style = SingleChoice.Style.Dropdown(
                        SingleChoice.SpinnerSetup.Filterable(
                            filter = { item, filter -> item.name.lowercase().contains(filter) },
                            label = filterLabel,
                            placeholder = filterPlaceholder,
                            showSpinnerForSingleItem = false
                        )
                    ),
                )
            } else {
                // we need a sub state for the dependency management between all the 3 levels
                val multiLevelState = rememberMultiLevelThemePicker(pickerState)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MultiLevelThemeSelectorCollection(
                        state = pickerState,
                        style = SingleChoice.Style.Dropdown(
                            SingleChoice.SpinnerSetup.Default(showSpinnerForSingleItem = false)
                        ),
                        multiState = multiLevelState,
                        modifier = Modifier.weight(1f)
                    )
                    MultiLevelThemeSelectorTheme(
                        state = pickerState,
                        multiState = multiLevelState,
                        style = SingleChoice.Style.Dropdown(
                            SingleChoice.SpinnerSetup.Filterable(
                                filter = { item, filter -> item.name.lowercase().contains(filter) },
                                label = filterLabel,
                                placeholder = filterPlaceholder,
                                minItemsToShowFilter = 10,
                                showSpinnerForSingleItem = false
                            )
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    MultiLevelThemeSelectorVariant(
                        state = pickerState,
                        style = SingleChoice.Style.Dropdown(
                            SingleChoice.SpinnerSetup.Default(showSpinnerForSingleItem = false)
                        ),
                        multiState = multiLevelState,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun DefaultThemePickerIconTextContent(
    data: SingleChoice.ItemData,
    icon: ImageVector?,
    text: String?
) {
    Row(
        modifier = data.modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(it, null)
        }
        Text(
            text = text ?: "",
            color = data.textColor(),
            maxLines = 1
        )
    }
}