package com.michaelflisar.composethemer.picker

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.BrightnessLow
import androidx.compose.material.icons.filled.BrightnessMedium
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.michaelflisar.composethemer.ComposeTheme
import com.michaelflisar.composethemer.picker.ThemePicker.SegmentedInfo

object ThemePicker {

    internal val DEFAULT_LABEL_WIDTH = 128.dp

    class Info(
        val label: String = "",
        val description: String = ""
    ) {
        fun isEmpty() = label.isEmpty() && description.isEmpty()
    }

    class SegmentedInfo(
        val label: String,
        val icon: ImageVector?
    )

    class Setup(
        val supportsDynamic: Boolean,
        val supportsSystemContrast: Boolean = true,
        val includeVariantsInThemePicker: Boolean = false,
        val labelWidth: Dp = 128.dp,
        val infoBaseTheme: Info = Info(
            label = "Base Theme"
        ),
        val infoContrast: Info = Info(
            label = "Contrast"
        ),
        val infoDynamic: Info = Info(
            label = "Dynamic Colors"
        ),
        val infoTheme: Info = Info(
            label = "Theme"
        ),
        val labelSearchTheme: String = "Search in themes",
        val labelSystem: String = "System",
        val provideBaseThemeInfo: (ComposeTheme.BaseTheme) -> SegmentedInfo = {
            when (it) {
                ComposeTheme.BaseTheme.Dark -> SegmentedInfo("", Icons.Default.DarkMode)
                ComposeTheme.BaseTheme.Light -> SegmentedInfo("", Icons.Default.LightMode)
                ComposeTheme.BaseTheme.System -> SegmentedInfo(labelSystem, null)
            }
        },
        val provideContrastInfo: (ComposeTheme.Contrast) -> SegmentedInfo = {
            when (it) {
                ComposeTheme.Contrast.Normal -> SegmentedInfo("", Icons.Default.BrightnessLow)
                ComposeTheme.Contrast.Medium -> SegmentedInfo("", Icons.Default.BrightnessMedium)
                ComposeTheme.Contrast.High -> SegmentedInfo("", Icons.Default.BrightnessHigh)
                ComposeTheme.Contrast.System -> SegmentedInfo(labelSystem, null)
            }
        }
    )
}

@Composable
fun ThemePicker(
    setup: ThemePicker.Setup,
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    contrast: MutableState<ComposeTheme.Contrast>,
    dynamic: MutableState<Boolean>,
    themeKey: MutableState<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // 1) Dark/Light
        ThemePickerBaseTheme(
            baseTheme = baseTheme,
            info = setup.infoBaseTheme,
            labelWidth = setup.labelWidth,
            infoProvider = setup.provideBaseThemeInfo
        )

        // 2) Dynamic
        if (setup.supportsDynamic) {
            ThemePickerDynamic(
                dynamic = dynamic,
                info = setup.infoDynamic,
                labelWidth = setup.labelWidth,
            )
        }

        // 3) Contrast
        ThemePickerContrast(
            contrast = contrast,
            info = setup.infoContrast,
            labelWidth = setup.labelWidth,
            infoProvider = setup.provideContrastInfo,
            supportsSystemContrast = setup.supportsSystemContrast,
            enabled = !dynamic.value
        )

        // 4) Theme
        if (setup.includeVariantsInThemePicker) {
            ThemePickerTheme(
                baseTheme = baseTheme,
                themeKey = themeKey,
                filterLabel = setup.labelSearchTheme,
                info = setup.infoTheme,
                labelWidth = setup.labelWidth,
                enabled = !dynamic.value
            )
        } else {

            ThemePickerGroupAndVariant(
                baseTheme = baseTheme,
                themeKey = themeKey,
                filterLabel = setup.labelSearchTheme,
                info = setup.infoTheme,
                labelWidth = setup.labelWidth,
                enabled = !dynamic.value
            )
            //ThemePickerVariant()
        }
    }
}

@Composable
fun ThemePickerBaseTheme(
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    modifier: Modifier = Modifier,
    info: ThemePicker.Info = ThemePicker.Info(),
    labelWidth: Dp = ThemePicker.DEFAULT_LABEL_WIDTH,
    infoProvider: (ComposeTheme.BaseTheme) -> SegmentedInfo,
    enabled: Boolean = true
) {
    ThemePickerRow(
        modifier = modifier,
        info = info,
        enabled = enabled,
        labelWidth = labelWidth
    ) {
        ThemePickerSingleChoice(
            items = listOf(
                ComposeTheme.BaseTheme.Light,
                ComposeTheme.BaseTheme.Dark,
                ComposeTheme.BaseTheme.System
            ),
            selected = baseTheme,
            infoProvider = infoProvider,
            enabled = enabled
        )
    }
}

@Composable
fun ThemePickerContrast(
    contrast: MutableState<ComposeTheme.Contrast>,
    modifier: Modifier = Modifier,
    info: ThemePicker.Info = ThemePicker.Info(),
    labelWidth: Dp = ThemePicker.DEFAULT_LABEL_WIDTH,
    infoProvider: (ComposeTheme.Contrast) -> SegmentedInfo,
    supportsSystemContrast: Boolean = true,
    enabled: Boolean = true
) {
    ThemePickerRow(
        modifier = modifier,
        info = info,
        enabled = enabled,
        labelWidth = labelWidth
    ) {
        ThemePickerSingleChoice(
            items = listOfNotNull(
                ComposeTheme.Contrast.Normal,
                ComposeTheme.Contrast.Medium,
                ComposeTheme.Contrast.High,
                ComposeTheme.Contrast.System.takeIf { supportsSystemContrast }
            ),
            selected = contrast,
            infoProvider = infoProvider,
            enabled = enabled
        )
    }
}

@Composable
fun ThemePickerDynamic(
    dynamic: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    info: ThemePicker.Info = ThemePicker.Info(),
    labelWidth: Dp = ThemePicker.DEFAULT_LABEL_WIDTH,
    enabled: Boolean = true
) {
    ThemePickerRow(
        modifier = modifier,
        info = info,
        enabled = enabled,
        labelWidth = labelWidth
    ) {
        Switch(checked = dynamic.value, onCheckedChange = { dynamic.value = it })
    }
}

@Composable
fun ThemePickerTheme(
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    themeKey: MutableState<String>,
    filterLabel: String,
    modifier: Modifier = Modifier,
    info: ThemePicker.Info = ThemePicker.Info(),
    labelWidth: Dp = ThemePicker.DEFAULT_LABEL_WIDTH,
    enabled: Boolean = true
) {
    val items by remember {
        derivedStateOf {
            ComposeTheme.getRegisteredThemes()
                .sortedBy { it.name.lowercase() }
        }
    }

    val isDark = baseTheme.value.isDark()

    ThemePickerRow(
        modifier = modifier,
        info = info,
        enabled = enabled,
        labelWidth = labelWidth
    ) {
        Spinner(
            items = items,
            selected = items.find { it.key == themeKey.value },
            onSelect = { themeKey.value = it.key },
            filter = { item, filter -> item.name.lowercase().contains(filter) },
            filterLabel = filterLabel,
            modifier = modifier,
            enabled = enabled
        ) { item, modifier ->
            ThemePreview(
                modifier = modifier,
                theme = item,
                selectedThemeKey = themeKey.value,
                isDark = isDark
            )
        }
    }
}

@Composable
fun ThemePickerGroupAndVariant(
    baseTheme: MutableState<ComposeTheme.BaseTheme>,
    themeKey: MutableState<String>,
    filterLabel: String,
    modifier: Modifier = Modifier,
    info: ThemePicker.Info = ThemePicker.Info(),
    labelWidth: Dp = ThemePicker.DEFAULT_LABEL_WIDTH,
    enabled: Boolean = true
) {
    val groups by remember {
        derivedStateOf {
            ComposeTheme.getRegisteredThemeGroups()
                .sortedBy { it.name.lowercase() }
        }
    }
    var variants by remember {
        mutableStateOf(emptyList<Enum<*>>())
    }

    val theme by remember(themeKey.value) {
        derivedStateOf {
            ComposeTheme.getRegisteredThemes()
                .find { it.key == themeKey.value }
        }
    }

    var selectedThemeGroup by remember { mutableStateOf(theme?.group) }
    var selectedVariant by remember { mutableStateOf(theme?.variant) }

    LaunchedEffect(selectedVariant, selectedThemeGroup) {
        val variant = selectedVariant
        val group = selectedThemeGroup
        if (variant != null && group != null) {
            val newKey = group.themes.find { it.variant == selectedVariant }?.key
            if (newKey != null) {
                themeKey.value = newKey
            }
        }

        variants = group?.getVariants() ?: emptyList()
        if (!variants.contains(selectedVariant)) {
            selectedVariant = group?.defaultVariant ?: variants.firstOrNull()
        }
    }

    val isDark = baseTheme.value.isDark()

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ThemePickerRow(
            modifier = modifier,
            info = info,
            enabled = enabled,
            labelWidth = labelWidth
        ) {
            Spinner(
                items = groups,
                selected = selectedThemeGroup,
                onSelect = {
                    selectedThemeGroup = it
                },
                filter = { item, filter -> item.name.lowercase().contains(filter) },
                filterLabel = filterLabel,
                modifier = Modifier.weight(1f),
                enabled = enabled
            ) { item, modifier ->
                ThemePreviewGroup(
                    modifier = Modifier.fillMaxWidth(),
                    group = item,
                    selectedGroup = selectedThemeGroup,
                    selectedVariant = selectedVariant,
                    isDark = isDark
                )
            }
            Spinner(
                items = variants,
                selected = selectedVariant,
                onSelect = {
                    selectedVariant = it
                },
                filter = null,
                filterLabel = "",
                modifier = Modifier.weight(1f),
                enabled = enabled
            ) { item, modifier ->
                Text(
                    modifier = modifier,
                    text = item?.name ?: "",
                    color = if (item == selectedVariant) MaterialTheme.colorScheme.primary else Color.Unspecified,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
private fun ThemePickerRow(
    info: ThemePicker.Info,
    labelWidth: Dp,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (info.isEmpty()) {
        content()
        return
    }

    Row(
        modifier = modifier.then(
            if (enabled) Modifier else Modifier.alpha(.38f)
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.width(labelWidth),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            if (info.label.isNotEmpty())
                Text(info.label, style = MaterialTheme.typography.bodyMedium)
            if (info.description.isNotEmpty())
                Text(info.description, style = MaterialTheme.typography.bodySmall)
        }
        content()
    }
}

@Composable
private fun <T> ThemePickerSingleChoice(
    items: List<T>,
    selected: MutableState<T>,
    infoProvider: (T) -> SegmentedInfo,
    enabled: Boolean = true
) {
    SingleChoiceSegmentedButtonRow {
        items.forEachIndexed { index, item ->
            SegmentedButton(
                selected = selected.value == item,
                onClick = { selected.value = item },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = items.size),
                enabled = enabled
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val info by remember(item) { derivedStateOf { infoProvider(item) } }
                    info.icon?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = null
                        )
                    }
                    info.label.takeIf { it.isNotEmpty() }?.let {
                        Text(it)
                    }
                }
            }
        }
    }
}

@Composable
private fun ThemePreview(
    modifier: Modifier,
    theme: ComposeTheme.Theme<*>?,
    selectedThemeKey: String,
    isDark: Boolean
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val colorScheme = theme?.getScheme(isDark, ComposeTheme.BaseContrast.Normal)
        PreviewColorScheme(colorScheme)
        Text(
            text = theme?.name ?: "",
            color = if (theme?.key == selectedThemeKey) MaterialTheme.colorScheme.primary else Color.Unspecified,
            modifier = Modifier.weight(1f),
            maxLines = 1
        )
    }
}

@Composable
private fun ThemePreviewGroup(
    modifier: Modifier,
    group: ComposeTheme.Group<*>?,
    selectedGroup: ComposeTheme.Group<*>?,
    selectedVariant: Enum<*>?,
    isDark: Boolean
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val groupThemes = group?.themes
        val colorScheme = groupThemes?.find { it.variant == selectedVariant }
            ?: groupThemes?.find { it.variant == group.defaultVariant }

        PreviewColorScheme(colorScheme?.getScheme(isDark, ComposeTheme.BaseContrast.Normal))
        Text(
            text = group?.name ?: "",
            color = if (group == selectedGroup) MaterialTheme.colorScheme.primary else Color.Unspecified,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun PreviewColorScheme(colorScheme: ColorScheme?) {
    if (colorScheme != null) {
        Canvas(
            modifier = Modifier.size(32.dp).padding(4.dp).clip(RoundedCornerShape(size = 4.dp))
        ) {

            val w = size.width
            val h = size.height
            val strokeWidth = 1.dp.toPx()

            drawRect(
                color = colorScheme.primary,
                topLeft = Offset(0f, 0f),
                size = Size(w / 2f, h),
                style = Fill
            )
            drawRect(
                color = colorScheme.secondary,
                topLeft = Offset(w / 2f, 0f),
                size = Size(w / 2f, h / 2f),
                style = Fill
            )
            drawRect(
                color = colorScheme.tertiary,
                topLeft = Offset(w / 2f, h / 2f),
                size = Size(w / 2f, h / 2f),
                style = Fill
            )

            drawLine(
                colorScheme.background,
                Offset(w / 2f, h / 2f),
                Offset(w, h / 2f),
                strokeWidth = strokeWidth
            )
            drawLine(
                colorScheme.background,
                Offset(w / 2f, 0f),
                Offset(w / 2f, h),
                strokeWidth = strokeWidth
            )
        }
    }
}

@Composable
private fun <T : Any> Spinner(
    items: List<T>,
    selected: T?,
    onSelect: (T) -> Unit,
    filter: ((item: T, filter: String) -> Boolean)?,
    filterLabel: String,
    modifier: Modifier,
    enabled: Boolean = true,
    content: @Composable (item: T?, modifier: Modifier) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(if (expanded) -180f else 0f)
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val filterText = remember { mutableStateOf("") }
        val filteredItems = remember(items) { mutableStateOf(items) }

        LaunchedEffect(filterText.value, filteredItems.value, expanded) {
            if (expanded) {
                filteredItems.value = items.filter { filter?.invoke(it, filterText.value) ?: true }
            }
        }
        LaunchedEffect(expanded) {
            if (!expanded) {
                filterText.value = ""
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surface)
                .clickable(enabled) {
                    expanded = !expanded
                }
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            content(selected, Modifier.weight(1f))
            Icon(
                modifier = Modifier.rotate(rotation),
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            if (filter != null) {
                OutlinedTextField(
                    value = filterText.value,
                    label = { Text(filterLabel) },
                    singleLine = true,
                    onValueChange = { filterText.value = it },
                    modifier = Modifier.fillMaxWidth().padding(all = 8.dp)
                )
            }

            filteredItems.value.forEach {
                DropdownMenuItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = {
                        content(it, Modifier.fillMaxWidth())
                    },
                    onClick = {
                        onSelect(it)
                        expanded = false
                    }
                )
            }
        }
    }
}