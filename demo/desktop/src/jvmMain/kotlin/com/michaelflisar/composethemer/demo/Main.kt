package com.michaelflisar.composethemer.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.themes.ComposeThemes
import com.michaelflisar.composethemer.themes.themes.ThemeGreenForest
import com.michaelflisar.toolbox.composables.MyCheckbox
import com.michaelflisar.toolbox.composables.MyColumn
import com.michaelflisar.toolbox.composables.MyDropdown
import com.michaelflisar.toolbox.composables.MySegmentedButtonRow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {

    // register available themes
    ComposeTheme.register(*ComposeThemes.ALL.toTypedArray())

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
            val dynamic = remember { mutableStateOf(false) }
            val theme = remember { mutableStateOf(ThemeGreenForest.KEY) }
            val state = ComposeTheme.State(baseTheme, dynamic, theme)

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
                        MyColumn {
                            val themes by remember {
                                derivedStateOf {
                                    ComposeTheme.getRegisteredThemes()
                                        .sortedBy { it.key.lowercase() }
                                }
                            }
                            // does not have an effect on windows!
                            //MyCheckbox(
                            //    title = "Dynamic Theme",
                            //    checked = dynamic,
                            //    onCheckedChange = {
                            //        dynamic.value = it
                            //    }
                            //)
                            MySegmentedButtonRow<ComposeTheme.BaseTheme>(
                                items = ComposeTheme.BaseTheme.entries.toList(),
                                selected = baseTheme,
                                //onSelectionChanged = {
                                //    baseTheme.value = it
                                //}
                            )
                            MyDropdown<ComposeTheme.Theme>(
                                title = "Base Theme",
                                items = themes,
                                mapper = { item, dropdown -> item.key },
                                selected = ComposeTheme.getRegisteredThemes()
                                    .find { it.key == theme.value }!!,
                                onSelectionChanged = {
                                    theme.value = it.key
                                }
                            )
                        }
                        Card {
                            Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                                Text("Preview", style = MaterialTheme.typography.titleMedium)
                                MyColumn {
                                    Text("Text")
                                    Text("Text Primary", color = MaterialTheme.colorScheme.primary)
                                    Text("Text Secondary", color = MaterialTheme.colorScheme.secondary)
                                    Card {
                                        Text("Card", modifier = Modifier.padding(16.dp))
                                    }
                                    ElevatedCard {
                                        Text("ElevatedCard", modifier = Modifier.padding(16.dp))
                                    }
                                }
                            }
                        }



                    }
                }
            }
        }
    }
}