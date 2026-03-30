package com.michaelflisar.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.michaelflisar.composechangelog.demo.BuildKonfig
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.DefaultThemePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoApp(
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    theme: MutableState<String>,
    statusBarColorPrimary: MutableState<Boolean> = remember { mutableStateOf(true) },
    navigationBarColorPrimary: MutableState<Boolean> = remember { mutableStateOf(true) },
) {
    val primary = MaterialTheme.colorScheme.primary
    val background = MaterialTheme.colorScheme.background

    val statusBarColor = remember(statusBarColorPrimary.value, primary, background) {
        derivedStateOf { if (statusBarColorPrimary.value) primary else background }
    }
    val navigationBarColor =
        remember(navigationBarColorPrimary.value, primary, background) {
            derivedStateOf { if (navigationBarColorPrimary.value) primary else background }
        }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = BuildKonfig.appName)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = statusBarColor.value,
                    titleContentColor = contentColorFor(statusBarColor.value),
                    actionIconContentColor = contentColorFor(statusBarColor.value)
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = navigationBarColor.value,
                tonalElevation = 0.dp,
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(Icons.Filled.Info, contentDescription = null)
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    // consume insets as scaffold doesn't do it by default
                    .consumeWindowInsets(padding)
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    LabeledCheckbox(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Toolbar / Status Bar Primary",
                        checked = statusBarColorPrimary
                    )
                    LabeledCheckbox(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Navigation Bar Primary",
                        checked = navigationBarColorPrimary
                    )
                }
                DemoContent(
                    modifier = Modifier.fillMaxWidth(),
                    baseTheme = baseTheme,
                    contrast = contrast,
                    dynamic = dynamic,
                    theme = theme
                )
            }
        }
    )
}

@Composable
private fun DemoContent(
    modifier: Modifier,
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    theme: MutableState<String>,
) {

    Column(
        modifier = modifier,
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
                singleLevelThemePicker = false
            )
        }
        val selectedTheme by remember(theme.value) {
            derivedStateOf {
                ComposeTheme.getRegisteredThemes().find { it.id == theme.value }
            }
        }
        Text("Preview", style = MaterialTheme.typography.titleMedium)
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {
                Text(
                    "Selected theme: ${selectedTheme?.fullName}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text("Theme supports contrast: ${selectedTheme?.supportsContrast()}")
                Text("Theme Group has variants: ${(selectedTheme?.group?.getVariantIds()?.size ?: 0) > 1}")
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ColorCard(MaterialTheme.colorScheme.primary, "Primary")
                    ColorCard(MaterialTheme.colorScheme.secondary, "Secondary")
                    ColorCard(MaterialTheme.colorScheme.tertiary, "Tertiary")
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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

@Composable
private fun RowScope.ColorCard(color: Color, label: String) {
    Card(
        modifier = Modifier.weight(1f),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Text(modifier = Modifier.padding(8.dp), text = label)
    }
}

@Composable
private fun LabeledCheckbox(
    label: String,
    checked: MutableState<Boolean>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Checkbox(checked = checked.value, onCheckedChange = { checked.value = it })
    }
}