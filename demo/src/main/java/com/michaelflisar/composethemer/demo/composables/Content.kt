package com.michaelflisar.composethemer.demo.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.demo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {

    // UI for color scheme demonstrations
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                val modifier = Modifier.weight(1f)

                // 1) Buttons
                ShowcaseRegion("Buttons")
                ShowcaseRow {
                    Button(modifier = modifier, onClick = {}) { Text("Button") }
                    ElevatedButton(
                        modifier = modifier,
                        onClick = {}) { Text("Elevated Button") }
                }
                ShowcaseRow {
                    OutlinedButton(
                        modifier = modifier,
                        onClick = {}) { Text("Outlined Button") }
                    FilledTonalButton(
                        modifier = modifier,
                        onClick = {}) { Text("Tonal Button") }
                }

                // 2) Cards
                ShowcaseRegion("Cards")
                val cardContent = @Composable { text: String ->
                    Box(modifier = Modifier.padding(all = 16.dp)) {
                        Text(text)
                    }
                }
                ShowcaseRow {
                    Card(modifier = modifier, onClick = {}) { cardContent("Card") }
                    ElevatedCard(
                        modifier = modifier,
                        onClick = {}) { cardContent("Elevated Card") }
                }
                ShowcaseRow {
                    OutlinedCard(
                        modifier = modifier,
                        onClick = {}) { cardContent("Outlined Card") }
                }

                // 3) Toggles (Checkboxes/Switches/RadioButtons)
                ShowcaseRegion("Checkboxes/Switches/RadioButtons")
                ShowcaseRow {
                    val check = remember { mutableStateOf(true) }
                    val radio = remember { mutableStateOf(true) }
                    val stateSwitch = remember { mutableStateOf(true) }
                    Checkbox(
                        modifier = modifier,
                        checked = check.value, onCheckedChange = { check.value = it })
                    RadioButton(
                        modifier = modifier,
                        selected = radio.value, onClick = { radio.value = !radio.value })
                    Switch(modifier = modifier,
                        checked = stateSwitch.value, onCheckedChange = { stateSwitch.value = it })
                }

                ShowcaseRegion("Chips")
                ShowcaseRow {
                    AssistChip(
                        modifier = modifier,
                        label = { Text("Assist Chip") },
                        onClick = {})
                    FilterChip(
                        modifier = modifier,
                        label = { Text("Filter Chip") },
                        selected = true,
                        onClick = {})
                }
                ShowcaseRow {
                    ElevatedAssistChip(
                        modifier = modifier,
                        label = { Text("Elevated Assist Chip") },
                        onClick = {})
                    ElevatedFilterChip(
                        modifier = modifier,
                        label = { Text("Elevated Filter Chip") },
                        selected = true,
                        onClick = {})
                }
                ShowcaseRow {
                    InputChip(
                        modifier = modifier,
                        label = { Text("Input Chip") },
                        selected = true,
                        onClick = {})
                    SuggestionChip(
                        modifier = modifier,
                        label = { Text("Suggestion Chip") },
                        onClick = {})
                }

                ShowcaseRegion("Sliders")
                ShowcaseRow {
                    val slide1 = remember { mutableStateOf(5f) }
                    val slide2 = remember { mutableStateOf(4f..6f) }
                    Slider(
                        modifier = modifier,
                        value = slide1.value,
                        valueRange = 0f..10f,
                        onValueChange = { slide1.value = it }
                    )
                    RangeSlider(
                        modifier = modifier,
                        value = slide2.value,
                        valueRange = 0f..10f,
                        onValueChange = { slide2.value = it }
                    )
                }

                ShowcaseRegion("Tabs")
                ShowcaseRegion("TextFields")
                ShowcaseRegion("Badges")
                ShowcaseRegion("BottomAppBars")
                ShowcaseRegion("Dividers")
                ShowcaseRegion("Progress")

            }
        }
    }
}

@Composable
private fun ShowcaseRegion(
    region: String
) {
    Text(
        text = region,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ShowcaseRow(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}