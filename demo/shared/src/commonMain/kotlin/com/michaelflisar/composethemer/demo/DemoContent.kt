package com.michaelflisar.composethemer.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.DefaultThemePicker

@Composable
fun DemoContent(
    modifier: Modifier,
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    theme: MutableState<String>,
    isSystemContrastSupported: Boolean, // only android supports system contrast
    isDynamicColorsSupported: Boolean // only android supports dynamic colors
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
                singleLevelThemePicker = false,
                isSystemContrastSupported = isSystemContrastSupported,
                isDynamicColorsSupported = isDynamicColorsSupported
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