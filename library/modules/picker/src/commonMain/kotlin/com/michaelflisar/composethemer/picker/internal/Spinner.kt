package com.michaelflisar.composethemer.picker.internal

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.michaelflisar.composethemer.picker.ThemePicker

@Composable
internal fun <T : Any> Spinner(
    items: List<T>,
    selected: T?,
    onSelect: (T) -> Unit,
    setup: ThemePicker.SpinnerSetup<T>,
    modifier: Modifier,
    enabled: Boolean = true,
    content: @Composable (item: T?, dropdown: Boolean, modifier: Modifier) -> Unit
) {
    if (items.size == 1 && !setup.showSpinnerForSingleItem) {
        // no need to show a spinner if we only have one item
        val item = items.first()
        Box(
            modifier = modifier.height(LocalMinimumInteractiveComponentSize.current),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(LocalMinimumInteractiveComponentSize.current)
                    .clip(MaterialTheme.shapes.small)
                    .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                content(item, false, Modifier.weight(1f))
            }
        }
        return
    }

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
                filteredItems.value = items.filter { item ->
                    when (setup) {
                        is ThemePicker.SpinnerSetup.Default -> true
                        is ThemePicker.SpinnerSetup.Filterable -> setup.filter(item, filterText.value)
                    }
                }
            }
        }
        LaunchedEffect(expanded) {
            if (!expanded) {
                filterText.value = ""
            }
        }

        SpinnerRow(
            onClick = {
                expanded = !expanded
            },
            enabled = enabled
        ) {
            content(selected, false, Modifier.weight(1f))
            Icon(
                modifier = Modifier.rotate(rotation),
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }

        val scrollState = rememberScrollState()
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            scrollState = scrollState,
            modifier = Modifier.width(IntrinsicSize.Min)
        ) {
            when (setup) {
                is ThemePicker.SpinnerSetup.Default -> {}

                is ThemePicker.SpinnerSetup.Filterable<*> -> {
                    if (setup.minItemsToShowFilter <= items.size) {
                        Column(
                            modifier = Modifier
                                .offset(y = with(LocalDensity.current) { scrollState.value.toDp() })
                                .background(MaterialTheme.colorScheme.surfaceContainer)
                                .padding(all = 8.dp)
                                .zIndex(2f)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            if (setup.label?.isNotEmpty() == true) {
                                Text(
                                    text = setup.label,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            OutlinedTextField(
                                value = filterText.value,
                                placeholder = setup.placeholder?.let { { Text(it) } },
                                singleLine = true,
                                onValueChange = { filterText.value = it },
                            )
                        }
                    }
                }
            }

            filteredItems.value.forEach {
                DropdownMenuItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .zIndex(1f),
                    text = {
                        content(it, true, Modifier.fillMaxWidth())
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

@Composable
internal fun SpinnerText(
    modifier: Modifier,
    text: String?,
    dropdown: Boolean,
    selected: Boolean
) {
    Text(
        modifier = modifier,
        text = text ?: "",
        color = if (selected && dropdown) MaterialTheme.colorScheme.primary else Color.Unspecified,
        maxLines = 1
    )
}

@Composable
private fun SpinnerRow(
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(LocalMinimumInteractiveComponentSize.current)
            .clip(MaterialTheme.shapes.small)
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.surface)
            .then(
                onClick?.let {
                    Modifier.clickable(
                        enabled = true,
                        onClick = it
                    )
                } ?: Modifier
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}