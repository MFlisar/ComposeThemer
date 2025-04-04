package com.michaelflisar.composethemer.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.BrightnessLow
import androidx.compose.material.icons.filled.BrightnessMedium
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LaptopWindows
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.FlatUIThemes
import com.michaelflisar.composethemer.Material500Themes
import com.michaelflisar.composethemer.MetroThemes
import com.michaelflisar.composethemer.picker.DefaultThemePicker
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.composethemer.picker.composables.ThemePickerRow
import com.michaelflisar.composethemer.picker.rememberThemePicker
import com.michaelflisar.composethemer.picker.composables.BaseThemePicker
import com.michaelflisar.composethemer.picker.composables.ContrastPicker
import com.michaelflisar.composethemer.picker.composables.MultiLevelThemeSelectorCollection
import com.michaelflisar.composethemer.picker.composables.MultiLevelThemeSelectorTheme
import com.michaelflisar.composethemer.picker.composables.MultiLevelThemeSelectorVariant
import com.michaelflisar.composethemer.picker.composables.SingleLevelThemeSelector
import com.michaelflisar.composethemer.picker.rememberMultiLevelThemePicker
import com.michaelflisar.composethemer.themes.DefaultThemes
import com.michaelflisar.composethemer.themes.ThemeDefault
import com.michaelflisar.toolbox.composables.MyColumn
import com.michaelflisar.toolbox.composables.MyRow

fun main() {

    // register available themes
    val allThemes: List<ComposeTheme.Theme> =
            DefaultThemes.getAllThemes() +
            MetroThemes.getAllThemes() +
            FlatUIThemes.getAllThemes() +
            Material500Themes.getAllThemes()
    ComposeTheme.register(*allThemes.toTypedArray())

    application {

        Window(
            title = "Compose Themer Demo",
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(
                position = WindowPosition(Alignment.Center),
                width = 800.dp,
                height = 600.dp
            )
        ) {
            val baseTheme = remember { mutableStateOf(ComposeTheme.BaseTheme.System) }
            val contrast = remember { mutableStateOf(ComposeTheme.Contrast.Normal) }
            val dynamic = remember { mutableStateOf(false) }
            val theme = remember { mutableStateOf(ThemeDefault.id) }
            val state = ComposeTheme.State(baseTheme, contrast, dynamic, theme)

            ComposeTheme(state = state) {
                Surface {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("Theme Settings", style = MaterialTheme.typography.titleMedium)
                        Card {
                            // check out the source code of [DefaultThemePicker] to see how to design your own layout
                            // I do provide states for easy implementations of your own layouts
                            // DefaultThemePicker is just an example...
                            DefaultThemePicker(
                                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                                baseTheme = baseTheme,
                                contrast = contrast,
                                dynamic = dynamic,
                                theme = theme,
                                singleLevelThemePicker = false,
                                isDynamicColorsSupported = false, // only android supports dynamic colors
                            )
                        }
                        val selectedTheme by remember(theme.value) { derivedStateOf { ComposeTheme.getRegisteredThemes().find { it.id == theme.value } } }
                        Text("Preview", style = MaterialTheme.typography.titleMedium)
                        Card {
                            MyColumn(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                                Text("Selected theme: ${selectedTheme?.fullName})", style = MaterialTheme.typography.titleMedium)
                                Text("Theme supports contrast: ${selectedTheme?.supportsContrast()}")
                                Text("Theme Group has variants: ${(selectedTheme?.group?.getVariantIds()?.size ?: 0) > 1}")
                                MyRow {
                                    ColorCard(MaterialTheme.colorScheme.primary, "Primary")
                                    ColorCard(MaterialTheme.colorScheme.secondary, "Secondary")
                                    ColorCard(MaterialTheme.colorScheme.tertiary, "Tertiary")
                                }
                                MyRow {
                                    ColorCard(
                                        MaterialTheme.colorScheme.primaryContainer,
                                        "Primary Container"
                                    )
                                    ColorCard(
                                        MaterialTheme.colorScheme.secondaryContainer,
                                        "Secondary Container"
                                    )
                                    ColorCard(
                                        MaterialTheme.colorScheme.tertiaryContainer,
                                        "Tertiary Container"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun RowScope.ColorCard(color: Color, label: String) {
    Card(
        modifier = Modifier.weight(1f),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Text(modifier = Modifier.padding(8.dp), text = label)
    }
}