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
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
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

object SingleChoice {

    sealed class Style<T : Any> {
        class SegmentedButton<T : Any> : Style<T>()
        class Dropdown<T : Any>(
            val setup: SpinnerSetup<T> = SpinnerSetup.Default(),
        ) : Style<T>()
    }

    class ItemData(
        val modifier: Modifier = Modifier,
        val dropdown: Boolean = false,
        val selected: Boolean = false,
    ) {
        @Composable
        fun textColor() =
            if (selected && dropdown) MaterialTheme.colorScheme.primary else Color.Unspecified
    }

    sealed class SpinnerSetup<T : Any> {
        abstract val showSpinnerForSingleItem: Boolean

        class Default<T : Any>(override val showSpinnerForSingleItem: Boolean = false) :
            SpinnerSetup<T>()

        class Filterable<T : Any>(
            val label: String?,
            val placeholder: String?,
            override val showSpinnerForSingleItem: Boolean = false,
            val minItemsToShowFilter: Int = 0,
            val filter: (item: T, filter: String) -> Boolean,
        ) : SpinnerSetup<T>()
    }
}

@Composable
internal fun <T : Any> SingleChoice(
    modifier: Modifier,
    items: List<T>,
    selected: T?,
    onSelect: (T) -> Unit,
    style: SingleChoice.Style<T>,
    enabled: Boolean = true,
    content: @Composable (item: T?, data: SingleChoice.ItemData) -> Unit,
) {
    when (style) {
        is SingleChoice.Style.SegmentedButton -> {
            SingleChoiceSegmentedButtonRow(modifier) {
                items.forEachIndexed { index, item ->
                    SegmentedButton(
                        selected = selected == item,
                        onClick = { onSelect(item) },
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = items.size
                        ),
                        enabled = enabled
                    ) {
                        content(item, SingleChoice.ItemData(selected = selected == item))
                    }
                }
            }
        }

        is SingleChoice.Style.Dropdown -> {
            Spinner(
                items = items,
                selected = selected,
                onSelect = {
                    onSelect(it)
                },
                setup = style.setup,
                modifier = modifier,
                enabled = enabled,
                content = content
            )
        }
    }
}

@Composable
private fun <T : Any> Spinner(
    items: List<T>,
    selected: T?,
    onSelect: (T) -> Unit,
    setup: SingleChoice.SpinnerSetup<T>,
    modifier: Modifier,
    enabled: Boolean = true,
    content: @Composable (item: T?, data: SingleChoice.ItemData) -> Unit,
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
                content(
                    item,
                    SingleChoice.ItemData(
                        dropdown = false,
                        selected = true,
                        modifier = Modifier.weight(1f)
                    )
                )
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
                        is SingleChoice.SpinnerSetup.Default -> true
                        is SingleChoice.SpinnerSetup.Filterable -> setup.filter(
                            item,
                            filterText.value
                        )
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
            content(
                selected,
                SingleChoice.ItemData(
                    dropdown = false,
                    selected = true,
                    modifier = Modifier.weight(1f)
                )
            )
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
                is SingleChoice.SpinnerSetup.Default -> {}

                is SingleChoice.SpinnerSetup.Filterable<*> -> {
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
                        content(
                            it,
                            SingleChoice.ItemData(
                                dropdown = true,
                                selected = it == selected,
                                modifier = Modifier.fillMaxWidth()
                            )
                        )
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
private fun SpinnerRow(
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
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
                        enabled = enabled,
                        onClick = it
                    )
                } ?: Modifier
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = content
    )
}