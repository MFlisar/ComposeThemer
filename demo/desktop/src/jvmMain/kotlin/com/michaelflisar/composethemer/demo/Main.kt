package com.michaelflisar.composethemer.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.michaelflisar.composethemer.MetroThemes
import com.michaelflisar.composethemer.picker.ThemePicker
import com.michaelflisar.toolbox.composables.MyColumn
import com.michaelflisar.toolbox.composables.MyRow

fun main() {

    // register available themes
    val allThemes: List<ComposeTheme.Theme> = ComposeTheme.DEFAULTS + MetroThemes.ALL
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
            val theme =
                remember { mutableStateOf(com.michaelflisar.composethemer.themes.ThemeDefault.key) }
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
                        ThemePicker(
                            setup = ThemePicker.Setup(
                                supportsDynamic = false
                            ),
                            baseTheme = baseTheme,
                            contrast = contrast,
                            dynamic = dynamic,
                            themeKey = theme,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Card {
                            MyColumn(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                                Text("Preview", style = MaterialTheme.typography.titleMedium)
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