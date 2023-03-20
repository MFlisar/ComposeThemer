package com.michaelflisar.composethemer.demo.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material.icons.filled.Style
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.michaelflisar.composedebugdrawer.core.*
import com.michaelflisar.composedebugdrawer.plugin.materialpreferences.DebugDrawerSettingCheckbox
import com.michaelflisar.composedebugdrawer.plugin.materialpreferences.DebugDrawerSettingSegmentedButtons
import com.michaelflisar.composedebugdrawer.plugin.materialpreferences.getDebugLabel
import com.michaelflisar.composedialogs.core.rememberDialogState
import com.michaelflisar.composedialogs.dialogs.color.DialogColor
import com.michaelflisar.composethemer.ComposeThemePrefs
import com.michaelflisar.composethemer.Theme
import com.michaelflisar.composethemer.collectAsState
import com.michaelflisar.composethemer.preferences.ThemePrefs
import com.michaelflisar.composethemer.preferences.ThemePrefsDark
import com.michaelflisar.composethemer.preferences.ThemePrefsLight
import com.michaelflisar.materialpreferences.core.interfaces.StorageSetting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    drawerState: DebugDrawerState
) {
    val scope = rememberCoroutineScope()
    DebugDrawerRegion(
        icon = Icons.Default.Style,
        label = "App Theme",
        collapsible = false,
        drawerState = drawerState
    ) {
        DebugDrawerSettingSegmentedButtons(
            setting = ThemePrefs.theme,
            items = Theme.values()
            //label = "Theme"
        )
        DebugDrawerSettingCheckbox(
            setting = ThemePrefs.dynamicTheme,
            label = "Dynamic Colors"
        )
        DebugDrawerButton(label = "Reset Colors") {
            scope.launch(Dispatchers.IO) {
                ThemePrefsLight.reset()
                ThemePrefsDark.reset()
            }
        }
    }
    val theme by ThemePrefs.theme.collectAsState()
    val dynamicTheme by ThemePrefs.dynamicTheme.collectAsState()
    val isDark = theme.isDark()
    val info = if (isDark) {
        "dark"
    } else {
        "light"
    }
    if (dynamicTheme) {
        DebugDrawerRegion(
            icon = Icons.Default.ColorLens,
            label = "Colors",
            id = "colors",
            collapsible = true,
            drawerState = drawerState
        ) {
            DebugDrawerInfo(
                title = "Dynamic Theme Selected",
                info = "Colors are calculated automatically, there are no color settings in this mode!"
            )
        }
    } else {

        DebugDrawerInfo(
            title = "Color Info",
            info = "Selected colors are applied to $info theme"
        )

        // Main Colors
        DebugDrawerRegion(
            icon = Icons.Default.ColorLens,
            label = "Main",
            id = "colors",
            collapsible = true,
            drawerState = drawerState
        ) {
            DebugColorSetting(ComposeThemePrefs::primary, isDark)
            DebugColorSetting(ComposeThemePrefs::onPrimary, isDark)
            DebugColorSetting(ComposeThemePrefs::secondary, isDark)
            DebugColorSetting(ComposeThemePrefs::onSecondary, isDark)
            DebugColorSetting(ComposeThemePrefs::tertiary, isDark)
            DebugColorSetting(ComposeThemePrefs::onTertiary, isDark)
        }

        // Container
        DebugDrawerRegion(
            icon = Icons.Default.ColorLens,
            label = "Container",
            collapsible = true,
            drawerState = drawerState
        ) {
            DebugColorSetting(ComposeThemePrefs::primaryContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::onPrimaryContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::secondaryContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::onSecondaryContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::tertiaryContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::onTertiaryContainer, isDark)
        }

        // Background/Surface
        DebugDrawerRegion(
            icon = Icons.Default.ColorLens,
            label = "Background/Surface",
            collapsible = true,
            drawerState = drawerState
        ) {
            DebugColorSetting(ComposeThemePrefs::background, isDark)
            DebugColorSetting(ComposeThemePrefs::onBackground, isDark)
            DebugColorSetting(ComposeThemePrefs::surface, isDark)
            DebugColorSetting(ComposeThemePrefs::onSurface, isDark)
            DebugColorSetting(ComposeThemePrefs::surfaceVariant, isDark)
            DebugColorSetting(ComposeThemePrefs::onSurfaceVariant, isDark)
            DebugColorSetting(ComposeThemePrefs::surfaceTint, isDark)
        }

        // Inverse
        DebugDrawerRegion(
            icon = Icons.Default.ColorLens,
            label = "Inverse",
            collapsible = true,
            drawerState = drawerState
        ) {
            DebugColorSetting(ComposeThemePrefs::inversePrimary, isDark)
            DebugColorSetting(ComposeThemePrefs::inverseSurface, isDark)
            DebugColorSetting(ComposeThemePrefs::inverseOnSurface, isDark)
        }

        // Specials
        DebugDrawerRegion(
            icon = Icons.Default.ColorLens,
            label = "Specials",
            collapsible = true,
            drawerState = drawerState
        ) {
            DebugColorSetting(ComposeThemePrefs::error, isDark)
            DebugColorSetting(ComposeThemePrefs::onError, isDark)
            DebugColorSetting(ComposeThemePrefs::errorContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::onErrorContainer, isDark)
            DebugColorSetting(ComposeThemePrefs::outline, isDark)
            DebugColorSetting(ComposeThemePrefs::outlineVariant, isDark)
            DebugColorSetting(ComposeThemePrefs::scrim, isDark)
        }
    }
}

@Composable
private fun DebugColorSetting(
    field: ComposeThemePrefs.() -> StorageSetting<Int>,
    darkTheme: Boolean
) {
    val scope = rememberCoroutineScope()
    val dialog = rememberDialogState()

    val field =
        if (darkTheme) ThemePrefsDark.field() else ThemePrefsLight.field()
    val colorDark by ThemePrefsDark.field().collectAsState()
    val colorLight by ThemePrefsLight.field().collectAsState()

    val currentColor by remember(darkTheme, colorDark, colorLight) {
        derivedStateOf {
            Color(if (darkTheme) colorDark else colorLight)
        }
    }
    val resettable by remember(field.value) {
        derivedStateOf {
            field.value != field.defaultValue
        }
    }

    val label = field.getDebugLabel()
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .clickable {
                dialog.show()
            }
            .padding(all = DebugDrawerDefaults.ITEM_PADDING),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(MaterialTheme.shapes.small)
                .background(currentColor)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = label,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "#${Integer.toHexString(currentColor.toArgb())}",
                style = MaterialTheme.typography.bodySmall
            )
        }
        if (resettable) {
            IconButton(
                modifier = Modifier.size(36.dp),
                onClick = {
                    scope.launch(Dispatchers.IO) {
                        field.reset()
                    }
                }) {
                Icon(imageVector = Icons.Default.Restore, contentDescription = null)
            }
        }
    }
    if (dialog.showing) {
        val color = remember { mutableStateOf(currentColor) }
        DialogColor(state = dialog, color = color) {
            if (it.isPositiveButton) {
                scope.launch(Dispatchers.IO) {
                    field.update(color.value.toArgb())
                }
            }
        }
    }
}